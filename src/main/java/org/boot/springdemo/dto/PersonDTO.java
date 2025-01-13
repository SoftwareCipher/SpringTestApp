package org.boot.springdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String phoneNumber;

    public PersonDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonDTO(Long id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

