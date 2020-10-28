package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Contact;
import com.npn.diasoft.test.repositories.interfaces.ContactRepository;
import com.npn.diasoft.test.services.hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {


    @Override
    public List<Contact> getAllByPersonId(BigDecimal personId) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        Query query =  session.createQuery("from Contact where personId =:id");
        query.setParameter("id",personId);
        List<Contact> retVal = query.list();
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return retVal;
    }

    @Override
    public void removeContact(BigDecimal id) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        Contact contact = session.get(Contact.class,id);
        session.delete(contact);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
    }

    @Override
    public void modifyContact(Contact contact) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        session.update(contact);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
    }

    @Override
    public Contact addContact(Contact contact) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        session.update(contact);
        BigDecimal id = (BigDecimal) session.save(contact);
        Contact retVal = contact.clone();
        retVal.setId(id);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return retVal;
    }


}
