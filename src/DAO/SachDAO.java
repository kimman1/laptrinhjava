/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Sach;
import java.util.List;
import model.Nhanvien;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author KimMan
 */
public class SachDAO {
    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
    public List<Sach> readAllSach()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Sach.class);
        List<Sach> result = cr.list();
        session.close();
        return result;
    }
    public void addSach(Sach sach)
    {
       
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sach);
        session.getTransaction().commit();
        session.close();
        //String hql = "INSERT INTO Sach(maSach,tenSach,tenTacGia,nxb,soLuong,giaSach)" + ;
    }
    public boolean checkDuplicate(String tenSach)
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Sach where tenSach = :TenSach";
        Query query = session.createQuery(hql);
        query.setParameter("TenSach", tenSach);
        List<Sach> result = query.list();
        session.close();
        if(result.isEmpty())
            return true;
        else
            return false;
    }
    public boolean checkDuplicate(String tenSach, String tenTacGia)
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Sach where tenSach = :TenSach and tenTacGia = :TenTacGia";
        Query query = session.createQuery(hql);
        query.setParameter("TenSach", tenSach);
        query.setParameter("TenTacGia",tenTacGia);
        List<Sach> result = query.list();
        session.close();
        if(result.isEmpty())
            return true;
        else
            return false;
    }
    public boolean checkDuplicate(String tenSach, String tenTacGia, int idSach)
    {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
         Criteria cr = session.createCriteria(Sach.class);
         cr.add(Restrictions.eq("tenSach", tenSach.trim()));
         List<Sach> rs =  cr.list();
        boolean result = false;
        for(Sach s : rs)
        {
           if( s.getTenSach().trim().equalsIgnoreCase(tenSach.trim()) && s.getTenTacGia().trim().equalsIgnoreCase(tenTacGia.trim()))
           {
               result = true;
              
           }
        }
        return result;
    }
 
    public void modifedSach(Sach sach)
    {
        Session session = sessionFactory.openSession();
        Sach sachSession = (Sach) session.get(Sach.class, sach.getMaSach());
        Transaction tx =  session.beginTransaction();
        sachSession.setGiaSach(sach.getGiaSach());
        sachSession.setNxb(sach.getNxb());
        sachSession.setSoLuong(sach.getSoLuong());
        sachSession.setTenSach(sach.getTenSach());
        sachSession.setTenTacGia(sach.getTenTacGia());
        session.update(sachSession);
        tx.commit();
        session.close();
    }
    public int deleteSach(int maSachDelete)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        String hql =  "delete Sach where maSach = :maSachDelete";
        Query query = session.createQuery(hql);
        query.setParameter("maSachDelete", maSachDelete);
        int result = query.executeUpdate();
        tx.commit();
        session.close();
        return result;
    }
    public List<Sach> searchSach(String SearchString, String searchType)
    {
        String hql = "";
        List<Sach> listResultSach;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        if(searchType.trim().equalsIgnoreCase("name"))
        {
             hql = "from Sach where tenSach like :searchString";
        }
        if(searchType.trim().equalsIgnoreCase("author"))
        {
             hql = "from Sach where tenTacGia like :searchString";
        }
        Query query = session.createQuery(hql);
        query.setParameter("searchString","%"+SearchString+"%");
        listResultSach = query.list();
        return listResultSach;
    }
    public void updateStockSach(Sach sach, String updateMethod)
    {
        Session session = sessionFactory.openSession();
        Transaction tx =  session.beginTransaction();
        String hql = "";
        if(updateMethod.trim().equalsIgnoreCase("plus"))
        {
            hql = "update Sach set soLuong= soLuong + :SoLuongUpdate where maSach = :MaSachUpdate";
        }
        if(updateMethod.trim().equalsIgnoreCase("minus"))
        {
             hql = "update Sach set soLuong= soLuong - :SoLuongUpdate where maSach = :MaSachUpdate";
        }
        
        Query query = session.createQuery(hql);
        query.setParameter("SoLuongUpdate", sach.getSoLuong());
        query.setParameter("MaSachUpdate", sach.getMaSach());
        query.executeUpdate();
        tx.commit();
        session.close();
        
    }
    
}
