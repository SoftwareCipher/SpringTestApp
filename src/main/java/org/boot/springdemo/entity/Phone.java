package org.boot.springdemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "phone")
@Data
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;
}
