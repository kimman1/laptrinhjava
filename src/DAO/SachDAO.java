/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sach;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KimMan
 */
public class SachDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<Sach> readAllSach()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Sach";
        Query query = session.createQuery(hql);
        List<Sach> result = query.list();
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
    public Sach readIdSach(String tenSach)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Sach where tenSach = :TenSach";
        Query query = session.createQuery(hql);
        query.setParameter("TenSach", tenSach);
        List<Sach> result = query.list();
        Sach sach = new Sach();
        session.close();
            //sach.setGiaSach(result.get(0).getGiaSach());
            sach.setMaSach(result.get(0).getMaSach());
           // sach.setNxb(result.get(0).getNxb());
            sach.setSoLuong(result.get(0).getSoLuong());
           // sach.setTenSach(result.get(0).getTenSach());
           // sach.setTenTacGia(result.get(0).getTenTacGia());
        
        return sach;
    }
    public void modifedSach(Sach sach)
    {
        Session session = sessionFactory.openSession();
        Sach sachSession = (Sach) session.get(Sach.class, sach.getMaSach());
        Transaction tx =  session.beginTransaction();
       /* String hql = "update Sach set tenSach = :tenSachUpdate, tenTacGia= :tenTacGiaUpdate, nxb = :NXBUpdate, soLuong = :soLuongUpdate, giaSach = :giaSachUpdate WHERE maSach = :maSachUpdate";
        Query query = session.createQuery(hql);
        query.setParameter("tenSachUpdate", sach.getTenSach());
        query.setParameter("tenTacGiaUpdate", sach.getTenTacGia());
        query.setParameter("NXBUpdate", sach.getNxb());
        query.setParameter("soLuongUpdate", sach.getSoLuong());
        query.setParameter("giaSachUpdate", sach.getGiaSach());
        query.setParameter("maSachUpdate", sach.getMaSach());
        int result = query.executeUpdate();*/
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
    public String readGiaSach(int idSach)
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Sach where maSach = :MaSach";
        Query query = session.createQuery(hql);
        query.setParameter("MaSach", idSach);
        List<Sach> listRs = query.list();
        session.close();
        String giasach = null;
        for(Sach s : listRs)
        {
            giasach = s.getGiaSach(); 
        }
        return giasach;
    }
}
