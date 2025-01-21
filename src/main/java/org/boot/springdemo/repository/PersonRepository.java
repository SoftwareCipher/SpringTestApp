package org.boot.springdemo.repository;

import org.boot.springdemo.dto.PersonDTO;
import org.boot.springdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);

    @Query("select new org.boot.springdemo.dto.PersonDTO(p.id, p.name, ph.phoneNumber) " +
            "from Person p join fetch Phone ph on p.id=ph.person.id where p.id =:id")
    PersonDTO findPersonById(Long id);
}
