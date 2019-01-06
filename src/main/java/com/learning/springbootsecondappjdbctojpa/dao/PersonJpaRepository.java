package com.learning.springbootsecondappjdbctojpa.dao;

import com.learning.springbootsecondappjdbctojpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional //this will ensure that all public methods within this class will act as a single transaction. if anything fails, everything within the method will be rolled back
public class PersonJpaRepository {

    //connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(long id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        entityManager.persist(person);
        return person;
    }


    public Person delete(long id){
        Person person = findById(id);
        entityManager.remove(person);
        return person;
    }

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("Person.findAll", Person.class);
        return namedQuery.getResultList();
    }
}
