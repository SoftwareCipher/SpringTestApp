package org.boot.springdemo.service;

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

    public Person findById() {
        Logger.info("findById");
        //спринг вызывает findById и ищет того кто реализовал метод -> Hiber
        return personRepository.findById(1L).orElse(null);
    }

    public Person findByName(String name) {
        return personRepository.findByName(name).orElse(null);
    }

    @Transactional
    public Person save() {
        Person person = new Person();
        person.setName("Admin");
        personRepository.save(person);

        Phone phone = new Phone();
        phone.setPhoneNumber(String.valueOf(123456789));
        person.setPhone(phone);
        phone.setPerson(person);
        return person;
    }

}
