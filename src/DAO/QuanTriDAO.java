/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Administrator;
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
public class QuanTriDAO {
    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
   public List<Administrator> readAllAdministrator()
    {
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        Criteria cr =  session.createCriteria(Administrator.class);
        List<Administrator> result = cr.list();
        session.close();
        return result;
    }
   public List<Administrator> quanTriLogin(String accountAdmin)
   {
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       Criteria cr = session.createCriteria(Administrator.class);
       cr.add(Restrictions.eq("accountAdmin", accountAdmin));
       List<Administrator> result =  cr.list();
       session.close();
       return result;
   }
}
