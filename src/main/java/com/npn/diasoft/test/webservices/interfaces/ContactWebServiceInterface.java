package com.npn.diasoft.test.webservices.interfaces;

import com.npn.diasoft.test.model.Contact;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;

@WebService
public interface ContactWebServiceInterface {

    @WebMethod()
    List<Contact> getAllContacts(BigDecimal personID);

    @WebMethod
    void removeContact(BigDecimal id);

    @WebMethod
    void modifyContact(Contact contact);

    @WebMethod
    Contact addContact(Contact contact);
}
