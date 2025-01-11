package org.boot.springdemo.service;

import org.boot.springdemo.entity.Person;
import org.boot.springdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinylog.Logger;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person findById() {
        Logger.info("findById");
        //Todo
        //спринг вызывает findById и ищет того кто реализовал метод -> Hiber
        return personRepository.findById(1L).orElse(null);
    }

    public Person findByName(String name) {
        return personRepository.findByName(name).orElse(null);
    }
}
