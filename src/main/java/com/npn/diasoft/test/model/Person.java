package com.npn.diasoft.test.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Представляет элемент человек, хранящийся в таблице "person"
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private BigDecimal id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "position")
    private String position;

    @XmlTransient
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
//    @JoinTable(name = "contact", joinColumns = @JoinColumn(name = "person_id",referencedColumnName = "id"))
    private final Set<Contact> contacts = new CopyOnWriteArraySet<>();

    /**
     * Создает объект человек с null значениями полей
     */
    public Person() {
    }

    /**
     * Создает объект человек с указанными значениями полей
     * @param id id человека
     * @param firstName имя
     * @param lastName фамилия
     * @param middleName отчество
     * @param position позиция
     */
    public Person(BigDecimal id, String firstName, String lastName, String middleName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
    }

    /**
     * Возвращает id человека
     * @return id человека
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Устианавливает id человека
     * @param id id человека
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * Возвращает имя
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Устаналивает имя
     * @param firstName имя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Возвращает фамилию
     * @return фамилия
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Устаналивате фамилию
     * @param lastName фамилия
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Возвращает отчество
     * @return отчество
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Устаналивает отчество
     * @param middleName отчество
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Возвращает позицию
     * @return позиция
     */
    public String getPosition() {
        return position;
    }

    /**
     * Устанавливает позицию
     * @param position позиция
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Получает список контактов
     * @return список контактов
     */
    public Set<Contact> getContacts() {
        return contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(middleName, person.middleName) &&
                Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, middleName, position);
    }
}
