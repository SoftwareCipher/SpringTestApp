package org.boot.springdemo.controller;

import org.boot.springdemo.dto.PersonDTO;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.service.PersonService;
import org.springframework.http.HttpStatus;
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

//    @GetMapping("/get")
//    public ResponseEntity<Person> getPerson() {
//        return ResponseEntity.ok(personService.findById());
//    }
//
//    @GetMapping("/get2")
//    public ResponseEntity<PersonDTO> getPersonWithPhone() {
//        Logger.info("Controller: getPersonWithPhone");
//        Person person = personService.findByIdWithPhone(1L);
//
//        if (person == null) {
//            return ResponseEntity.notFound().build();
//        }
//        PersonDTO personDTO = new PersonDTO(
//                person.getId(),
//                person.getName(),
//                person.getPhone() != null ? person.getPhone().getPhoneNumber() : null
//        );
//        return ResponseEntity.ok(personDTO);
//    }
//
//    @GetMapping("/save")
//    public ResponseEntity<Person> savePerson() {
//        Logger.info("Controller: save Person");
//        return ResponseEntity.ok(personService.save());
//    }


    //////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        Logger.info("Controller: getPerson");
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/{id}/with-phone")
    public ResponseEntity<PersonDTO> getPersonWithPhone(@PathVariable Long id) {
        Logger.info("Controller: getPersonWithPhone");
        return ResponseEntity.ok(personService.findByIdWithPhone(id));
    }

    @PostMapping
    public ResponseEntity<Void> savePerson(@RequestBody PersonDTO personDTO) {
        Logger.info("Controller: savePerson");
        personService.savePersonWithPhone(personDTO.getName(), personDTO.getPhoneNumber());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
