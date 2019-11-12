/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Nhanvien;
import java.util.List;
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
public class NhanVienDAO {
    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
    public List<Nhanvien> readAllNV()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Nhanvien.class);
        List<Nhanvien> result = cr.list();
        session.close();
        return result;
    }
    public Nhanvien readIdNV(String tenNV)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Nhanvien where tenNv = :TenNV";
        Query query = session.createQuery(hql);
        query.setParameter("TenNV", tenNV);
        List<Nhanvien> result = query.list();
        Nhanvien nv = new Nhanvien();
        session.close();
            nv.setMaNV(result.get(0).getMaNV()); 
        return nv;
    }
    
     public void addNV(Nhanvien nv)
    {
       
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        session.save(nv);
        session.getTransaction().commit();
        session.close();
        
    }
     public void deleteNV(Nhanvien nv)
     {
          Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Nhanvien nvSession = (Nhanvien) session.get(Nhanvien.class, nv.getMaNV());
        nvSession.setStatusNV("Đã Nghỉ");
        session.update(nvSession);
        tx.commit();
        session.close();
     }
     public void modifedNV(Nhanvien nv)
    {
        Session session = sessionFactory.openSession();
        Nhanvien nvSession = (Nhanvien) session.get(Nhanvien.class, nv.getMaNV());
        Transaction tx =  session.beginTransaction();
        nvSession.setAccountNV(nv.getAccountNV());
        nvSession.setPasswordNV(nv.getPasswordNV());
        nvSession.setSdtNV(nv.getSdtNV());
        nvSession.setStatusNV(nv.getStatusNV());
        nvSession.setTenNV(nv.getTenNV());
        nvSession.setNgaySinhNV(nv.getNgaySinhNV());
        session.update(nvSession);
        tx.commit();
        session.close();
    }
     public boolean checkDuplicateNV(String accountNV)
     {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
         Criteria cr = session.createCriteria(Nhanvien.class);
         cr.add(Restrictions.eq("accountNv", accountNV));
        List<Nhanvien> result = cr.list();
        if(result.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
     }
      public boolean checkDuplicateNV(String accountNv, int idNv)
    {
         Session session = sessionFactory.openSession();
        session.beginTransaction();
         Criteria cr = session.createCriteria(Nhanvien.class);
         cr.add(Restrictions.eq("accountNv", accountNv));
         List<Nhanvien> rs =  cr.list();
        boolean result = false;
        for(Nhanvien s : rs)
        {
            if(s.getAccountNV().trim().equalsIgnoreCase(accountNv) && s.getMaNV()== idNv)
            {
                
            }
            else
            {
                result = true;
            }
        }
        return result;
    }
     public List<Nhanvien> searchNV(String SearchString, String searchType)
    {
        String hql = "";
        List<Nhanvien> listResultSach;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //Criteria cr = session.createCriteria(Nhanvien.class, )
        if(searchType.trim().equalsIgnoreCase("name"))
        {
             hql = "from Nhanvien where tenNv like :searchString";
        }
        if(searchType.trim().equalsIgnoreCase("phone"))
        {
             hql = "from Nhanvien where sdtNv like :searchString";
        }
        Query query = session.createQuery(hql);
        query.setParameter("searchString","%"+SearchString+"%");
        listResultSach = query.list();
        return listResultSach;
    }
    
}
