package org.boot.springdemo.controller;

import org.boot.springdemo.entity.Person;
import org.boot.springdemo.service.PersonService;
import org.springframework.web.bind.annotation.*;
import org.tinylog.Logger;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get")
    public Person getPerson() {
        Logger.info("Controller: get Person");
        return personService.findById();
    }
}
