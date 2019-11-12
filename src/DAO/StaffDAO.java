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
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author KimMan
 */
public class StaffDAO {
    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
    public List<Nhanvien> staffLogin(String accountNV)
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Nhanvien where accountNV = :accountNV";
        Criteria cr = session.createCriteria(Nhanvien.class);
        cr.add(Restrictions.eq("accountNv", accountNV));
        List<Nhanvien> listStaff = cr.list();
        session.close();
        return listStaff;
    }
}
