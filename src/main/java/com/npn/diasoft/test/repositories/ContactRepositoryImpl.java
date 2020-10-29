package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Contact;
import com.npn.diasoft.test.repositories.interfaces.ContactRepository;
import com.npn.diasoft.test.services.hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * Реализация интерфейса {@link ContactRepository}
 */
public class ContactRepositoryImpl implements ContactRepository {

    /**
     * Получает все контакты по ID человека
     * @param personId id человека
     * @return список контактов или пустой список
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public List<Contact> getAllByPersonId(BigDecimal personId) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        Query query =  session.createQuery("from Contact where personId =:id");
        query.setParameter("id",personId);
        List<Contact> retVal = query.list();
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return retVal;
    }

    /**
     * Удаляет контакт по его id
     * @param id id контакта
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public void deleteContact(BigDecimal id) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        Contact contact = session.get(Contact.class,id);
        session.delete(contact);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
    }

    /**
     * Изменяет контакт
     * @param contact контакт с новыми значениями
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public void modifyContact(Contact contact) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        session.update(contact);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
    }

    /**
     * Добавляет новый контакт
     * @param contact новый контакт
     * @return новый элемент с заполненными полями
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public Contact addContact(Contact contact) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        BigDecimal id = (BigDecimal) session.save(contact);
        Contact retVal = new Contact(id,contact.getPersonId(),contact.getContactTypeId(),contact.getNumber());
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return retVal;
    }


}
