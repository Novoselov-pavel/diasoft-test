package com.npn.diasoft.test.repositories.interfaces;

import com.npn.diasoft.test.model.Contact;

import java.math.BigDecimal;
import java.util.List;

public interface ContactRepository {

    List<Contact> getAllByPersonId(BigDecimal personId);

    void removeContact(BigDecimal id);

    void modifyContact(Contact contact);

    Contact addContact(Contact contact);
}
