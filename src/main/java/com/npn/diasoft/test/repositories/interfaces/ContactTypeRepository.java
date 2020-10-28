package com.npn.diasoft.test.repositories.interfaces;

import com.npn.diasoft.test.model.ContactType;

import java.math.BigDecimal;

public interface ContactTypeRepository {
    ContactType getContactTypeById(BigDecimal id);
    ContactType addContactType(ContactType contactType);
    void deleteContactType(ContactType contactType);
}
