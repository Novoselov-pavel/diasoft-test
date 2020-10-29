package com.npn.diasoft.test.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Представляет элемент тип контакта, хранящийся в таблице "contact_type"
 */
@Entity
@Table(name = "contact_type")
public class ContactType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private BigDecimal id;

    @Column(name = "type")
    private String type;

    /**
     * Создает тип контакта с null значениями полей
     */
    public ContactType() {
    }

    /**
     * Создает тип контакта с указанными значениями полей
     * @param id id типа контакта
     * @param type описание типа контакта
     */
    public ContactType(BigDecimal id, String type) {
        this.id = id;
        this.type = type;
    }
    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_type_id")
    private final Set<Contact> contacts = new CopyOnWriteArraySet<>();

    /**
     * Возвращает id типа контакта
     * @return id типа контакта
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Устанавливает id типа контакта
     * @param id id типа контакта
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * Ворзвращает описание типа контакта
     * @return описание типа контакта
     */
    public String getType() {
        return type;
    }

    /**
     * Получает описание типа контакта
     * @param type описание типа контакта
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Возвращает список контактов данного типа
     * @return описание типа контакта
     */
    public Set<Contact> getContacts() {
        return contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactType that = (ContactType) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
