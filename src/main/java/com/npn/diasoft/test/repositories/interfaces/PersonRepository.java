package com.npn.diasoft.test.repositories.interfaces;

import com.npn.diasoft.test.model.Person;

import java.math.BigDecimal;

/**
 * Интерфейс по работе с объектами человек
 */
public interface PersonRepository {

    /**
     * Получает человека по его id
     * @param id id человека
     * @return объект человек или null
     * @throws RuntimeException при ошибках hibernate
     */
    Person getPersonById(BigDecimal id);

    /**
     * Добавляет человека c новыми данными
     * @param person объект человек с новыми данными
     * @return новый объект человек с заполненными вынными
     * @throws RuntimeException при ошибках hibernate
     */
    Person addPerson(Person person);

    /**
     * Удаляет человека
     * @param person человек
     */
    void deletePerson(Person person);
}
