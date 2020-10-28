package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Contact;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ContactRepositoryImplTest {


    @Test
    public void getAllByPersonId() {
        ContactRepositoryImpl repository = new ContactRepositoryImpl();
        List<Contact> list = repository.getAllByPersonId(new BigDecimal(1));
    }
}