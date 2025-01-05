package org.boot.springdemo.dto;

import org.boot.springdemo.entity.Phone;

import java.util.Set;

public record PersonDTO(Long id, String name, Set<Phone> phones) {
}
