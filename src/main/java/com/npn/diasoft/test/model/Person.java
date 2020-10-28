package com.npn.diasoft.test.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

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

    @OneToMany()
//    @JoinColumn(name = "person_id")
//    @JoinTable(name = "contact", joinColumns = @JoinColumn(name = "person_id",referencedColumnName = "id"))
    private final Set<Contact> contacts = new CopyOnWriteArraySet<>();


}
