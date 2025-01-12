package org.boot.springdemo.service;

import jakarta.persistence.EntityNotFoundException;
import org.boot.springdemo.dto.PersonDTO;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.entity.Phone;
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

//    public Person findById() {
//        Logger.info("findById");
//        Person person = personRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
//        person.setPhone(null);
//        return person;
//    }

//    @Transactional
//    public Person findByIdWithPhone(Long id) {
//        Logger.info("findByIdWithPhone");
//        Person person = personRepository.findById(id).orElse(null);
//        if (person != null && person.getPhone() != null) {
//            person.getPhone().getPhoneNumber();
//        }
//        return person;
//    }

//    @Transactional
//    public Person save() {
//        Person person = new Person();
//        person.setName("Admin");
//        personRepository.save(person);
//
//        Phone phone = new Phone();
//        phone.setPhoneNumber(String.valueOf(123456789));
//        person.setPhone(phone);
//        phone.setPerson(person);
//        return person;
//    }


    /////////////////////////////////////////////////////////////////////////////////////////


    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        Logger.info("findById");
        return personRepository.findById(id)
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getName(),
                        null // Не возвращаем телефон
                ))
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    @Transactional(readOnly = true)
    public PersonDTO findByIdWithPhone(Long id) {
        Logger.info("findByIdWithPhone");
        return personRepository.findById(id)
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getName(),
                        person.getPhone() != null ? person.getPhone().getPhoneNumber() : null
                ))
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    @Transactional
    public void savePersonWithPhone(String name, String phoneNumber) {
        Person person = new Person();
        person.setName(name);
        personRepository.save(person);

        if (phoneNumber != null) {
            Phone phone = new Phone();
            phone.setPhoneNumber(phoneNumber);
            phone.setPerson(person);
            person.setPhone(phone);
        }
    }
}
