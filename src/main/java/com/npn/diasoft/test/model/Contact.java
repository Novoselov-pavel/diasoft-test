package com.npn.diasoft.test.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Представляет элемент контакт, хранящийся в таблице "contacts"
 */
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private BigDecimal id;

    @Column(name = "person_id")
    private BigDecimal personId;

    @Column(name="contact_type_id")
    private BigDecimal contactTypeId;

    @Column(name = "number")
    private String number;

    /**
     * Создает контакт с null значениями полей
     */
    public Contact() {
    }

    /**
     * Создает контакт с переданными значениями полей
     * @param id id поле
     * @param personId id поле объекта {@link Person} которому принадлежит контакт
     * @param contactTypeId id поля типа контакта - объекта {@link ContactType}
     * @param number номер контакта
     */
    public Contact(BigDecimal id, BigDecimal personId, BigDecimal contactTypeId, String number) {
        this.id = id;
        this.personId = personId;
        this.contactTypeId = contactTypeId;
        this.number = number;
    }


    /**
     * Возвращает id контакта
     * @return  id контакта
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Устанавливает id контакта
     * @param id id контакта
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * Возвращает id поле объекта {@link Person} которому принадлежит контакт
     * @return id поле объекта {@link Person} которому принадлежит контакт
     */
    public BigDecimal getPersonId() {
        return personId;
    }

    /**
     * Устанавливает id поле объекта {@link Person} которому принадлежит контакт
     * @param personId id поле объекта {@link Person} которому принадлежит контакт
     */
    public void setPersonId(BigDecimal personId) {
        this.personId = personId;
    }

    /**
     * Возвращает id поля типа контакта - объекта {@link ContactType}
     * @return id поля типа контакта - объекта {@link ContactType}
     */
    public BigDecimal getContactTypeId() {
        return contactTypeId;
    }

    /**
     * Устанавливает id поля типа контакта - объекта {@link ContactType}
     * @param contactTypeId id поля типа контакта - объекта {@link ContactType}
     */
    public void setContactTypeId(BigDecimal contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    /**
     * Возвращает номер контакта
     * @return номер контакта
     */
    public String getNumber() {
        return number;
    }

    /**
     * Устанавливает номер контакта
     * @param number номер контакта
     */
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(personId, contact.personId) &&
                Objects.equals(contactTypeId, contact.contactTypeId) &&
                Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personId, contactTypeId, number);
    }
}
