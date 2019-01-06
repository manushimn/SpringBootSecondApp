package com.learning.springbootsecondappjdbctojpa;

import com.learning.springbootsecondappjdbctojpa.dao.PersonJpaRepository;
import com.learning.springbootsecondappjdbctojpa.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)    //Launch Spring ApplicationContext
@SpringBootTest
public class PersonRepositoryTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository personJpaRepository;

    @Test
    public void findById_basic(){
        Person person = personJpaRepository.findById(10002);
        assertEquals("hasanka", person.getName());
    }

    @Test
    @DirtiesContext //after the test is run, spring would reset the data so that other tests won't have any effect
    public void deleteById_basic(){
        personJpaRepository.delete(10033);
        assertNull(personJpaRepository.findById(10033));
    }
}
