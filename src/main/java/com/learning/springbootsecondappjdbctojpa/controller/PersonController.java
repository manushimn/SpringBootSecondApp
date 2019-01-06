package com.learning.springbootsecondappjdbctojpa.controller;

import com.learning.springbootsecondappjdbctojpa.dao.PersonJpaRepository;
import com.learning.springbootsecondappjdbctojpa.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    public static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll(){
        List<Person> persons =  personJpaRepository.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable long id){
        logger.info("Fetching User with id {}", id);

        Person person =  personJpaRepository.findById(id);

        if (person == null) {
            logger.error("Person with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> insertPerson(@RequestBody Person person){
        logger.info("Inserting User with id {}", person.getId());

        Person updatedPerson =  personJpaRepository.insert(person);

        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        logger.info("Updating User with id {}", person.getId());

        Person updatedPerson =  personJpaRepository.update(person);

        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable long id){
        logger.info("Deleting User with id {}", id);

        Person person =  personJpaRepository.delete(id);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

}
