package org.boot.springdemo.service;

import org.boot.springdemo.dto.PersonWithPhoneDTO;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        Logger.info("Service: save Person : {}", person);
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        Logger.info("Service: find all Person");
        return personRepository.findAll();
    }

    public List<PersonWithPhoneDTO> getPersonsWithPhone(Long id) {
        return personRepository.findPersonWithPhones(id);
    }
}
