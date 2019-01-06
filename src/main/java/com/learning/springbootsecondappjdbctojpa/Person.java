package com.learning.springbootsecondappjdbctojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String location;

    @Column(name="birth_date")
    private Date birthDate;

    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }
}
