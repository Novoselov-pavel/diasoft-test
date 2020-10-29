package com.npn.diasoft.test.repositories;

import com.npn.diasoft.test.model.ContactType;
import com.npn.diasoft.test.repositories.interfaces.ContactTypeRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Тест для ContactTypeRepositoryImpl
 */
public class ContactTypeRepositoryImplTest {

    /**
     * Тестирует создание, получение и удаление типа контакта одновременно,
     * чтобы не оставлять следов в базе данных при успешном завершении (и для экономии времени разработки).
     * Не выполнены тесты на выбрасывание исключений и добавление контактов для экономии времени разработки.
     */
    @Test
    public void addAndGetAndDeleteTest(){
        ContactType contactType = new ContactType(null,getRandomString(10));
        ContactTypeRepository repository = new ContactTypeRepositoryImpl();
        ContactType savedContactType = null;
        ContactType getContactType = null;
        try {
            savedContactType = repository.addContactType(contactType);
            Assert.assertEquals("ContactType save failed, Type expected: " + contactType.getType() +
                            " actual: " + savedContactType.getType(),
                    contactType.getType(),savedContactType.getType());

        } catch (Throwable e) {
            e.printStackTrace();
            fail("Exception on saving Person. " + e.getMessage());
            return;
        }

        try {
            getContactType = repository.getContactTypeById(savedContactType.getId());
            Assert.assertEquals("Saved and get ContactType doesn't equal",savedContactType,getContactType);
        } catch (Throwable e) {
            e.printStackTrace();
            fail("Exception on get ContactType. " + e.getMessage());
            return;
        }

        try {
            repository.deleteContactType(savedContactType);

            ContactType expectedNullContactType = repository.getContactTypeById(savedContactType.getId());
            Assert.assertNull("Failed to delete person ",expectedNullContactType);
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