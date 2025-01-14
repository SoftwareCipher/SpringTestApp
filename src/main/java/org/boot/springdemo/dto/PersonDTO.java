package org.boot.springdemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private Long id;
    @NotNull(message = "Name must not be null")
    @NotBlank(message = "Name must be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 char")
    private String name;
    @Pattern(regexp = "^(\\+380|380|0)\\d{9}$",
            message = "Phone number must start 0 and contain 8 numbers")
    private String phoneNumber;

    public PersonDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

