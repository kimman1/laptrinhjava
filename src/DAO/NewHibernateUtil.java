package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author KimMan
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        Configuration configure = new Configuration();
        configure.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder
                = new StandardServiceRegistryBuilder()
                .applySettings(configure.getProperties());
        sessionFactory = configure
                .buildSessionFactory(builder.build());
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
