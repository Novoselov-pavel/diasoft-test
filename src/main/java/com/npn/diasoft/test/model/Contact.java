package com.npn.diasoft.test.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contacts")
public class Contact implements Cloneable {

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

    public Contact() {
    }

    public Contact(BigDecimal id, BigDecimal personId, BigDecimal contactTypeId, String number) {
        this.id = id;
        this.personId = personId;
        this.contactTypeId = contactTypeId;
        this.number = number;
    }

    //    @ManyToOne
////    @JoinColumn(name = "person_id")
//    private Person person;
//
//    @ManyToOne
////    @JoinColumn(name = "contact_type_id")
//    private ContactType contactType;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getPersonId() {
        return personId;
    }

    public void setPersonId(BigDecimal personId) {
        this.personId = personId;
    }

    public BigDecimal getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(BigDecimal contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public Contact clone() {
        return new Contact(this.getId(),this.personId, this.contactTypeId, this.number);
    }
}
