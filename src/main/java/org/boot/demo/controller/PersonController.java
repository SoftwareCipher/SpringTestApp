package org.boot.demo.controller;

import jakarta.validation.Valid;
import org.boot.demo.dto.PersonDTO;
import org.boot.demo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> findAll() {
        Logger.info("findAll");
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/{id}/without_phone")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        Logger.info("Controller: getPerson");
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonWithPhone(@PathVariable Long id) {
        Logger.info("Controller: getPersonWithPhone");
        return ResponseEntity.ok(personService.findByIdWithPhone(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Void> savePerson(@Valid @RequestBody PersonDTO personDTO) {
        Logger.info("Controller: savePerson");
        personService.savePerson(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO) {
        Logger.info("Controller: updatePerson");
        personService.updatePerson(id, personDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        Logger.info("Controller: deletePerson");
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
