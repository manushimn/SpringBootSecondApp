package com.learning.springbootsecondappjdbctojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String location;
    private Date birth_date;
}
