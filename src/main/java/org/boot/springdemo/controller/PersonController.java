package org.boot.springdemo.controller;

import org.boot.springdemo.dto.PersonWithPhoneDTO;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/get")
    public List<Person> getPersons() {
        Logger.info("Controller: save Person");
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public List<PersonWithPhoneDTO> getPersonWithPhones(@PathVariable Long id){
        Logger.info("Controller: get Person with id: " + id + " with phones");
        return personService.getPersonsWithPhone(id);
    }
}
