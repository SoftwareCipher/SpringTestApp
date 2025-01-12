package org.boot.springdemo.controller;

import org.boot.springdemo.entity.Person;
import org.boot.springdemo.service.PersonService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Person> getPerson() {
        Logger.info("Controller: get Person");
        return ResponseEntity.ok(personService.findById());
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Person> getPerson(@PathVariable String name) {
        Logger.info("Controller: get Person by name");
        return ResponseEntity.ok(personService.findByName(name));
    }

    @GetMapping("/save")
    public ResponseEntity<Person> savePerson() {
        Logger.info("Controller: save Person");
        return ResponseEntity.ok(personService.save());
    }
}
