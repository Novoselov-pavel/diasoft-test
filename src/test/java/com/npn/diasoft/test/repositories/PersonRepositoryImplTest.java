package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.Person;
import com.npn.diasoft.test.repositories.interfaces.PersonRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Тесты класса PersonRepositoryImpl
 */
public class PersonRepositoryImplTest {

    /**
     * Тестирует создание, получение и удаление пользователя одновременно,
     * чтобы не оставлять следов в базе данных при успешном завершении (и для экономии времени разработки).
     * Не выполнены тесты на выбрасывание исключений и добавление контактов для экономии времени разработки.
     */
    @Test
    public void addAndGetAndDeletePersonTest(){
        Person person = new Person(null,
                getRandomString(10),
                getRandomString(10),
                getRandomString(10),
                getRandomString(20));

        PersonRepository repository = new PersonRepositoryImpl();
        Person savedPerson = null;
        Person getPerson = null;

        try {
            savedPerson = repository.addPerson(person);
            Assert.assertEquals("Person save failed, FirstName expected: " + person.getFirstName() + " actual: " + savedPerson.getFirstName(),
                    person.getFirstName(), savedPerson.getFirstName());
            Assert.assertEquals("Person save failed, LastName expected: " + person.getLastName() + " actual: " + savedPerson.getLastName(),
                    person.getLastName(), savedPerson.getLastName());
            Assert.assertEquals("Person save failed, MiddleName expected: " + person.getMiddleName() + " actual: " + savedPerson.getMiddleName(),
                    person.getMiddleName(), savedPerson.getMiddleName());
            Assert.assertEquals("Person save failed, Position expected: " + person.getPosition() + " actual: " + savedPerson.getPosition(),
                    person.getPosition(), savedPerson.getPosition());
        } catch (Throwable e) {
            e.printStackTrace();
            fail("Exception on saving Person. " + e.getMessage());
            return;
        }

        try {
            getPerson = repository.getPersonById(savedPerson.getId());
            Assert.assertEquals("Saved and getPerson doesn't equal",savedPerson,getPerson);
        } catch (Throwable e) {
            e.printStackTrace();
            fail("Exception on get Person. " + e.getMessage());
            return;
        }

        try {
            getPerson = repository.getPersonById(savedPerson.getId());
            Assert.assertEquals("Saved and get Person doesn't equal",savedPerson,getPerson);
        } catch (Throwable e) {
            e.printStackTrace();
            fail("Exception on get Person. " + e.getMessage());
            return;
        }

        try {
            repository.deletePerson(savedPerson);
            Person expectedNullPerson = repository.getPersonById(savedPerson.getId());
            Assert.assertNull("Failed to delete person ",expectedNullPerson);
        } catch (Throwable e) {
            e.printStackTrace();
            fail("Exception on delete Person. " + e.getMessage());
            return;
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
}