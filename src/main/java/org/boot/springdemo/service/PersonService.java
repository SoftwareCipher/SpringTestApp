package org.boot.springdemo.service;

import org.boot.springdemo.entity.Person;
import org.boot.springdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById() {
        Logger.info("findById");
        return personRepository.findById(1L).orElse(null);
    }

    public Person findByName(String name) {
        return personRepository.findByName(name).orElse(null);
    }
}
