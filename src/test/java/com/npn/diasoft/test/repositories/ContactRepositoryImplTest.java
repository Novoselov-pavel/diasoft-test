package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Contact;
import com.npn.diasoft.test.model.ContactType;
import com.npn.diasoft.test.model.Person;
import com.npn.diasoft.test.repositories.interfaces.ContactRepository;
import com.npn.diasoft.test.repositories.interfaces.ContactTypeRepository;
import com.npn.diasoft.test.repositories.interfaces.PersonRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.*;
/**
 * Тестирование  ContactRepositoryImpl
 */
public class ContactRepositoryImplTest {


    private Person person;
    private ContactType contactType;
    private List<Contact> contacts;
    private PersonRepository personRepository;
    private ContactRepository contactRepository;
    private ContactTypeRepository contactTypeRepository;

    @Before
    public void init(){
        personRepository = new PersonRepositoryImpl();
        contactRepository = new ContactRepositoryImpl();
        contactTypeRepository = new ContactTypeRepositoryImpl();
        Person person = new Person(null,getRandomString(10),getRandomString(10),getRandomString(10),getRandomString(10));
        person = personRepository.addPerson(person);
        this.person = person;

        ContactType contactType = new ContactType(null,getRandomString(10));
        contactType = contactTypeRepository.addContactType(contactType);
        this.contactType = contactType;

        ArrayList<Contact> contacts = new ArrayList<>();
        Contact firstContact = new Contact(null,person.getId(),contactType.getId(),getRandomString(15));
        Contact secondContact = new Contact(null,person.getId(),contactType.getId(),getRandomString(15));

        firstContact = contactRepository.addContact(firstContact);
        secondContact = contactRepository.addContact(secondContact);

        contacts.add(firstContact);
        contacts.add(secondContact);

        this.contacts = contacts;

    }


    @Test
    public void getAllByPersonId() {
        try {
            List<Contact> list = contactRepository.getAllByPersonId(person.getId());
            Assert.assertEquals("Error, contact lists aren't equal", list,contacts);
        } catch (Throwable e) {
          e.printStackTrace();
          fail();
        }
    }

    @Test
    public void deleteAndAddContact() {
        try {
            Contact contact = new Contact(null,person.getId(),contactType.getId(),getRandomString(10));
            contact = contactRepository.addContact(contact);
            Contact  getContact = contactRepository.getContactById(contact.getId());
            Assert.assertEquals("Contact save failed, PersonId expected: " + contact.getPersonId() + " actual: " + getContact.getPersonId(),
                    contact.getPersonId(), getContact.getPersonId());
            Assert.assertEquals("Contact save failed, ContactTypeId expected: " + contact.getContactTypeId() + " actual: " + getContact.getContactTypeId(),
                    contact.getContactTypeId(), getContact.getContactTypeId());
            Assert.assertEquals("Contact save failed, Number expected: " + contact.getNumber() + " actual: " + getContact.getNumber(),
                    contact.getNumber(), getContact.getNumber());

            contactRepository.deleteContact(contact.getId());
            Contact  expectedNullContact = contactRepository.getContactById(contact.getId());
            Assert.assertNull("Failed to delete contact ",expectedNullContact);

        } catch (Throwable e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void modifyContact() {
       try {
           Contact contact = new Contact(null,person.getId(),contactType.getId(),getRandomString(10));
           contact = contactRepository.addContact(contact);
           contact.setNumber(getRandomString(10));
           contactRepository.modifyContact(contact);

           Contact newContact = contactRepository.getContactById(contact.getId());
           Assert.assertEquals("Failed to modify contact", contact, newContact);
           contactRepository.deleteContact(contact.getId());
       } catch (Throwable e) {
           e.printStackTrace();
           fail();
       }

    }


    /**
     * Получение рандомной строки
     * @param length длина строки
     * @return рандомная строка a-z
     */
    private String getRandomString(int length){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @After
    public void remove(){
        contacts.forEach(x->contactRepository.deleteContact(x.getId()));
        contactTypeRepository.deleteContactType(contactType);
        personRepository.deletePerson(person);
    }

}