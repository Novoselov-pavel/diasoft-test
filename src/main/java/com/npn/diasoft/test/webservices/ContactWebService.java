package com.npn.diasoft.test.webservices;

import com.npn.diasoft.test.model.Contact;
import com.npn.diasoft.test.repositories.ContactRepositoryImpl;
import com.npn.diasoft.test.repositories.interfaces.ContactRepository;
import com.npn.diasoft.test.webservices.interfaces.ContactWebServiceInterface;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Реализация интерфейса web-сервися по работе с контактами
 */
@WebService(serviceName = "ContactWebService",
        endpointInterface = "com.npn.diasoft.test.webservices.interfaces.ContactWebServiceInterface",
        portName = "ContactWebService")
public class ContactWebService implements ContactWebServiceInterface {


    private final ContactRepository contactRepository = new ContactRepositoryImpl();

    /**
     * Возвращает список контактов по id человека
     * @param personId id человека
     * @return список контактов
     */
    @WebMethod
    @Override
    public ArrayList<Contact> getAllContacts(BigDecimal personId) {
        ArrayList<Contact> list = new ArrayList<>(contactRepository.getAllByPersonId(personId));
        return list;
    }

    /**
     * Удаляет контакт
     * @param id id контакта
     */
    @WebMethod
    @Override
    public void removeContact(BigDecimal id) {
        contactRepository.deleteContact(id);
    }

    /**
     * Изменяет контакт
     * @param contact контакт с новыми данными
     */
    @WebMethod
    @Override
    public void modifyContact(Contact contact) {
        contactRepository.modifyContact(contact);
    }

    /**
     * Добавляет контакт
     * @param contact контакт с новыми данными
     * @return контакт с новыми данными с заполненным id
     */
    @WebMethod
    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.addContact(contact);
    }

}
