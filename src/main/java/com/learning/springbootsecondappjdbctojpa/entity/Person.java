package com.learning.springbootsecondappjdbctojpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String location;

    @Column(name="birth_date")
    private LocalDateTime birthDate;

    public Person(String name, String location, LocalDateTime birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person(long id, String name, String location, LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
