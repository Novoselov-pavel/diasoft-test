package com.npn.diasoft.test.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Entity
@Table(name = "contact_type")
public class ContactType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private BigDecimal id;

    @Column(name = "type")
    private String type;

    @OneToMany()
//    @JoinColumn(name = "contact_type_id")
//    @JoinTable(name = "contact", joinColumns = @JoinColumn(name = "contact_type_id",referencedColumnName = "id"))
    private final Set<Contact> contacts = new CopyOnWriteArraySet<>();

}
