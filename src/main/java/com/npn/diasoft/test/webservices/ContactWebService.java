package com.npn.diasoft.test.webservices;

import com.npn.diasoft.test.model.Contact;
import com.npn.diasoft.test.repositories.ContactRepositoryImpl;
import com.npn.diasoft.test.repositories.interfaces.ContactRepository;
import com.npn.diasoft.test.webservices.interfaces.ContactWebServiceInterface;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.util.List;


@WebService(serviceName = "ContactWebService",
        endpointInterface = "com.npn.diasoft.test.webservices.interfaces.ContactWebServiceInterface",
        portName = "ContactWebService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ContactWebService implements ContactWebServiceInterface {

    private final ContactRepository contactRepository = new ContactRepositoryImpl();


    @WebMethod
    @Override
    public List<Contact> getAllContacts(BigDecimal personId) {
        return contactRepository.getAllByPersonId(personId);
    }

    @WebMethod
    @Override
    public void removeContact(BigDecimal id) {
        contactRepository.removeContact(id);
    }

    @WebMethod
    @Override
    public void modifyContact(Contact contact) {
        contactRepository.modifyContact(contact);
    }

    @WebMethod
    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.addContact(contact);
    }
}
