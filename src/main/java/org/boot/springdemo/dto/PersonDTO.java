package org.boot.springdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String phoneNumber;

    public PersonDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

