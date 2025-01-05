package org.boot.springdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonWithPhoneDTO {
    private String personName;
    private String phoneNumber;

    public PersonWithPhoneDTO(String personName, String phoneNumber) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
    }
}
