package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Person;
import com.npn.diasoft.test.repositories.interfaces.PersonRepository;
import com.npn.diasoft.test.services.hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
/**
 * Реализация интерфейса по работе с объектами человек
 */
public class PersonRepositoryImpl implements PersonRepository {

    /**
     * Получает человека по его id
     * @param id id человека
     * @return объект человек или null
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public Person getPersonById(BigDecimal id) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        Person person = session.get(Person.class,id);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return person;
    }

    /**
     * Добавляет человека c новыми данными
     * @param person объект человек с новыми данными
     * @return новый объект человек с заполненными вынными
     * @throws RuntimeException при ошибках hibernate
     */
    @Override
    public Person addPerson(Person person) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        BigDecimal id = (BigDecimal) session.save(person);
        Person retVal = new Person(id,person.getFirstName(), person.getLastName(), person.getMiddleName(), person.getPosition());
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
        return retVal;
    }

    /**
     * Удаляет человека
     * @param person человек
     */
    @Override
    public void deletePerson(Person person) {
        Session session = HibernateSessionFactoryUtil.beginTransaction();
        session.delete(person);
        HibernateSessionFactoryUtil.commitTransactionAndCloseSession(session);
    }
}
