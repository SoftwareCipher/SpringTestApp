package org.boot.springdemo.service;

import jakarta.transaction.Transactional;
import org.boot.springdemo.entity.Person;
import org.boot.springdemo.entity.Phone;
import org.boot.springdemo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;


    @Test
    public void testFindAllWithPhones() {
        List<Person> people = personRepository.findAllWithPhones();
        for (Person person : people) {
            System.out.println("Person: " + person.getName());
            for (Phone phone : person.getPhones()) {
                System.out.println("Phone: " + phone.getPhoneNumber());
            }
        }
    }
}