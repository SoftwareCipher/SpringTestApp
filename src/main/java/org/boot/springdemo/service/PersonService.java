package org.boot.springdemo.service;

import org.boot.springdemo.dto.PersonDTO;
import org.boot.springdemo.dto.PersonWithPhoneDTO;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<PersonDTO> findAll() {
        List<Person> people = personRepository.findAllWithPhones();
        List<PersonDTO> dtos = new ArrayList<>();
        for (Person p : people) {
            dtos.add(new PersonDTO(p.getId(), p.getName(), p.getPhones()));
        }
        Logger.info("Service: findAll Person : {}", dtos);
        return dtos;
    }

    public List<PersonWithPhoneDTO> getPersonsWithPhone(Long id) {
        // open session hiber
        return personRepository.findPersonWithPhones(id);
        // close session hiber
    }
}
