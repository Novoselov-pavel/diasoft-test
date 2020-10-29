package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.ContactType;
import com.npn.diasoft.test.repositories.interfaces.ContactTypeRepository;
import com.npn.diasoft.test.services.hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.math.BigDecimal;

/**
 * Реализация интерфейса по работе с типами контактов
 */
public class ContactTypeRepositoryImpl implements ContactTypeRepository {

    /**
     * Получает тип контакта по его id
     * @param id id типа контакта
     * @return тип контакта или null
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public ContactType getContactTypeById(BigDecimal id) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        ContactType contactType = session.get(ContactType.class,id);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return contactType;
    }

    /**
     * Добавляет новый тип контакта
     * @param contactType новый тип котакта
     * @return новый элемент с заполненными полями
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public ContactType addContactType(ContactType contactType) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        BigDecimal id = (BigDecimal) session.save(contactType);
        ContactType retVal = new ContactType(id,contactType.getType());
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return retVal;
    }

    /**
     * Удаляет тип контакта
     * @param contactType тип контакта
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public void deleteContactType(ContactType contactType) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        session.delete(contactType);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
    }
}
