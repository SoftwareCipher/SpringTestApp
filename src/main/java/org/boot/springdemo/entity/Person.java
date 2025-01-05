package org.boot.springdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phones")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private Set<Phone> phones;
}
