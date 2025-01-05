package org.boot.springdemo.repository;

import org.boot.springdemo.dto.PersonWithPhoneDTO;
import org.boot.springdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "SELECT p.name AS personName, ph.phone_number AS phoneNumber " +
            "FROM person p JOIN phone ph ON p.id = ph.person_id " +
            "WHERE p.id = :personId",
            nativeQuery = true)
    List<PersonWithPhoneDTO> findPersonWithPhones(Long personId);
}
