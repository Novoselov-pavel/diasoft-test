package com.npn.diasoft.test.repositories.interfaces;

import com.npn.diasoft.test.model.ContactType;

import java.math.BigDecimal;

/**
 * Интерфейс репозитория по работе с типами контактов
 */
public interface ContactTypeRepository {

    /**
     * Получает тип контакта по его id
     * @param id id типа контакта
     * @return тип контакта или null
     * @throws RuntimeException при ошибках hibernate
     */
    ContactType getContactTypeById(BigDecimal id);

    /**
     * Добавляет новый тип контакта
     * @param contactType новый тип котакта
     * @return новый элемент с заполненными полями
     * @throws RuntimeException при ошибках hibernate
     */
    ContactType addContactType(ContactType contactType);

    /**
     * Удаляет тип контакта
     * @param contactType тип контакта
     * @throws RuntimeException при ошибках hibernate
     */
    void deleteContactType(ContactType contactType);
}
