package com.JoaoLucas.spring_boot_application.Aula03.repository;

import com.JoaoLucas.spring_boot_application.Aula03.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
