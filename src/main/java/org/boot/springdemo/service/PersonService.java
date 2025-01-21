package org.boot.springdemo.service;

import jakarta.persistence.EntityNotFoundException;
import org.boot.springdemo.dto.PersonDTO;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.entity.Phone;
import org.boot.springdemo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinylog.Logger;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO findById(Long id) {
        Logger.info("findById");
        return personRepository.findById(id)
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getName()
                ))
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    public PersonDTO findByIdWithPhone(Long id) {
        Logger.info("findByIdWithPhone");
        return personRepository.findPersonById(id);
    }

    @Transactional
    public void savePerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());

        Phone phone = new Phone();
        phone.setPhoneNumber(personDTO.getPhoneNumber());
        person.setPhone(phone);
        phone.setPerson(person);

        personRepository.save(person);
    }

    @Transactional
    public void updatePerson(Long id, PersonDTO personDTO) {
        Logger.info("updatePerson");
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with ID="
                        + id + " not found"));
        person.setName(personDTO.getName());
        person.getPhone().setPhoneNumber(personDTO.getPhoneNumber());
    }

    public void deletePerson(Long id) {
        Logger.info("deletePerson");
        personRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream().map(person -> new PersonDTO(
                person.getId(),
                person.getName(),
                person.getPhone() != null ? person.getPhone().getPhoneNumber() : null
        )).toList();
    }
}
