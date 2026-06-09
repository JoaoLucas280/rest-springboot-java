package com.JoaoLucas.spring_boot_application.Aula03.service;

import com.JoaoLucas.spring_boot_application.Aula03.exception.ResourceNotFoundException;
import com.JoaoLucas.spring_boot_application.Aula03.model.Person;
import com.JoaoLucas.spring_boot_application.Aula03.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter  = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding Person with id: " + id);
        return repository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Person not found for this id: " + id));
    }


    public Person createPerson(Person person) {
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating Person");
        Person entity = repository.findById(person.getId()).orElseThrow
                (() -> new ResourceNotFoundException("Person not found for this id: " + person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void deletePerson(Long id) {
        logger.info("Deleting Person");

        Person entity = repository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Person not found for this id: " + id));

        repository.delete(entity);
    }


    private Person mockPerson(int i) {
        logger.info("Finding all");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("name + " + i);
        person.setLastName("Last name - " + i);
        person.setAddress("address - " + i);
        person.setGender("Male");
        return person;

    }
}
