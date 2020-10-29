package com.npn.diasoft.test.services.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Класс фабрика для фабрики сессий, сессии hibernate а также для работы с сессиями и транзакциями
 */
public class HibernateSessionFactoryUtil {
    private static volatile SessionFactory sessionFactory;

    /**
     * Возвращает {@link SessionFactory}. Синглетон.
     * @return SessionFactory
     */
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

    /**
     * Возвращает сессию.
     * @return сессия
     */
    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }

    /**
     * Возвращает сессию с открытой транзакцией
     * @return
     */
    public static Session beginTransaction(){
        Session session = getSession();
        session.beginTransaction();
        return  session;
    }

    /**
     * Выыполняет сommit для транзакции и закрыватет сессию
     * @param s сессия
     */
    public static void commitTransactionAndCloseSession(Session s){
        s.getTransaction().commit();
        s.close();
    }

}
