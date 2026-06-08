package com.JoaoLucas.spring_boot_application.Aula03.service;

import com.JoaoLucas.spring_boot_application.Aula03.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter  = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    public Person findById(String id) {
        logger.info("Finding Person with id: " + id);

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Joao");
        person.setLastName("Lucas");
        person.setAddress("Campo Grande - MS - Brasil");
        person.setGender("Male");
        return person;
    }


    public Person createPerson(Person person) {
        logger.info("Creating one person");

        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating Person");
        return person;
    }

    public void deletePerson(String id) {
        logger.info("Deleting Person");

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
