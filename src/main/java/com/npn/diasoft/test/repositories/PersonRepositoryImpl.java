package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Person;
import com.npn.diasoft.test.repositories.interfaces.PersonRepository;

import java.math.BigDecimal;

public class PersonRepositoryImpl implements PersonRepository {
    @Override
    public Person getPersonById(BigDecimal id) {
        return null;
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public void deletePerson(Person person) {

    }
}
