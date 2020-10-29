package com.npn.diasoft.test.webservices;

import com.npn.diasoft.test.model.Contact;
import com.npn.diasoft.test.repositories.interfaces.ContactRepository;
import com.npn.diasoft.test.repositories.interfaces.ContactTypeRepository;
import com.npn.diasoft.test.repositories.interfaces.PersonRepository;
import com.npn.diasoft.test.webservices.interfaces.ContactWebServiceInterface;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.*;

public class ContactWebServiceTest {
    private static final String URL = "http://localhost:8080/contact?wsdl";
    private static final String NAMESPACE_URL = "http://webservices.test.diasoft.npn.com/";
    private static final String LOCALE_PORT = "ContactWebService";

    ContactWebServiceInterface contactWebService;
    ContactRepository contactRepository;
    ContactTypeRepository contactTypeRepository;
    PersonRepository personRepository;

    public ContactWebServiceTest() throws MalformedURLException {
        QName qName = new QName(NAMESPACE_URL,LOCALE_PORT);
        Service service = Service.create(new URL(URL),qName);
        contactWebService = service.getPort(ContactWebServiceInterface.class);
    }

    public static void main(String[] args) throws MalformedURLException {
        ContactWebServiceTest test = new ContactWebServiceTest();
        List<Contact> contactList = test.getAllContacts(new BigDecimal(1));
        System.out.println("");
    }




    public List<Contact> getAllContacts(BigDecimal personId) {
        return contactWebService.getAllContacts(personId);
    }


    public void removeContact(BigDecimal id) {
        contactWebService.removeContact(id);
    }


    public void modifyContact(Contact contact) {
        contactWebService.modifyContact(contact);
    }

    public Contact addContact(Contact contact) {
        return contactWebService.addContact(contact);
    }
}