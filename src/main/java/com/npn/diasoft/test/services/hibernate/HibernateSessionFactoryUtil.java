package com.npn.diasoft.test.services.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static volatile SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null) {
            synchronized (HibernateSessionFactoryUtil.class){
                SessionFactory local = sessionFactory;
                if (local == null) {
                    Configuration configuration = new Configuration().configure();
                    SessionFactory session = configuration.buildSessionFactory();
                    sessionFactory = session;
                }
            }
        }
        return sessionFactory;
    }


    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }

    public static Session beginTransaction(){
        Session session = getSession();
        session.beginTransaction();
        return  session;
    }

    public static void commitTransactionAndCloseSession(Session s){
        s.getTransaction().commit();
        s.close();
    }

}
