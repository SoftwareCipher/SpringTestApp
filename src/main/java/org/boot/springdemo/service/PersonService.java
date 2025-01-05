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
        Logger.info("Service: find all Person");
        // open session hiber
        List<Person> people = personRepository.findAllWithPhones();
        // close session hiber
        Logger.info("Start forEach");
        List<PersonDTO> dtos = new ArrayList<>();
        for (Person p : people) {
            PersonDTO dto = new PersonDTO(p.getId(), p.getName(), p.getPhones());
            dtos.add(dto);
        }
        Logger.info(dtos.toString());
        Logger.info("Finish forEach");
//        return people.stream()
////                .map(p -> new PeronDTO(p.getId(), p.getName()))
////                .toList();
        return Collections.EMPTY_LIST;
    }

    public List<PersonWithPhoneDTO> getPersonsWithPhone(Long id) {
        // open session hiber
        return personRepository.findPersonWithPhones(id);
        // close session hiber
    }
}
