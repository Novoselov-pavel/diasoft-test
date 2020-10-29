package com.npn.diasoft.test.webservices.interfaces;

import com.npn.diasoft.test.model.Contact;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Интерфейс web-сервися по работе с контактами
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ContactWebServiceInterface {

    /**
     * Возвращает список контактов по id человека
     * @param personId id человека
     * @return список контактов
     */
    @WebMethod()
    ArrayList<Contact> getAllContacts(BigDecimal personId);

    /**
     * Удаляет контакт
     * @param id id контакта
     */
    @WebMethod
    void removeContact(BigDecimal id);

    /**
     * Изменяет контакт
     * @param contact контакт с новыми данными
     */
    @WebMethod
    void modifyContact(Contact contact);

    /**
     * Добавляет контакт
     * @param contact контакт с новыми данными
     * @return контакт с новыми данными с заполненным id
     */
    @WebMethod
    Contact addContact(Contact contact);
}
