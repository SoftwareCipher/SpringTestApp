package org.boot.springdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "phone")
@Getter
@Setter
public class Phone {
    @Id
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "person_id")
    @MapsId
    private Person person;
}


