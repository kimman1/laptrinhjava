/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Administrator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author KimMan
 */
public class QuanTriDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
   public List<Administrator> readAdministrator()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        String hql = "FROM Administrator";
        Query query = session.createQuery(hql);
        List<Administrator> result = query.list();
        return result;
    }
   public List<Administrator> quanTriLogin(String accountAdmin)
   {
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       String hql = "from Administrator where accountAdmin = :maAdminQuery" ;
       Query query = session.createQuery(hql);
       query.setParameter("maAdminQuery", accountAdmin);
       List<Administrator> result =  query.list();
       return result;
   }
}
