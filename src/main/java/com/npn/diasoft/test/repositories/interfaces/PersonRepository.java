package com.npn.diasoft.test.repositories.interfaces;

import com.npn.diasoft.test.model.ContactType;
import com.npn.diasoft.test.model.Person;

import java.math.BigDecimal;

public interface PersonRepository {
    Person getPersonById(BigDecimal id);
    Person addPerson(Person person);
    void deletePerson(Person person);
}
