package org.boot.springdemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Phone> phones;

    @Override
    public String toString() {
        return "Person{" +
                "phones=" + phones +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}