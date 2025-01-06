package org.boot.springdemo.dto;

import org.boot.springdemo.entity.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public record PersonDTO(Long id, String name, List<Phone> phones) {
    public PersonDTO(Long id, String name, Set<Phone> phones) {
        this(id, name, new ArrayList<>(phones));
    }
}
