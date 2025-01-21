package org.boot.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phone")
@Getter
@Setter
@RequiredArgsConstructor
public class Phone {
    @Id
    Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @MapsId
    @JsonIgnore
    private Person person;
}


