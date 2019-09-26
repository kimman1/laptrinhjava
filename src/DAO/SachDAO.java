/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Khachhang;
import Model.Sach;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    
}
