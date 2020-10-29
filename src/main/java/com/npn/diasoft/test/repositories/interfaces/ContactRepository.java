package com.npn.diasoft.test.repositories.interfaces;

import com.npn.diasoft.test.model.Contact;

import java.math.BigDecimal;
import java.util.List;

/**
 * Инетерфейс репозитория работы с контактами
 */
public interface ContactRepository {

    /**
     * Возвращает контакт по его id
     * @param id id контакта
     * @return контакт или null если не найден
     * @throws RuntimeException при ошибках hibernate
     */
    Contact getContactById(BigDecimal id);

    /**
     * Получает все контакты по ID человека
     * @param personId id человека
     * @return список контактов или пустой список
     * @throws RuntimeException при ошибках hibernate
     */
    List<Contact> getAllByPersonId(BigDecimal personId);

    /**
     * Удаляет контакт по его id
     * @param id id контакта
     * @throws RuntimeException при ошибках hibernate
     */
    void deleteContact(BigDecimal id);

    /**
     * Изменяет контакт
     * @param contact контакт с новыми значениями
     * @throws RuntimeException при ошибках hibernate
     */
    void modifyContact(Contact contact);

    /**
     * Добавляет новый контакт
     * @param contact новый контакт
     * @return новый элемент с заполненными полями
     * @throws RuntimeException при ошибках hibernate
     */
    Contact addContact(Contact contact);
}
