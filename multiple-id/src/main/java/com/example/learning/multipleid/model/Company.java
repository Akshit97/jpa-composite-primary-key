package com.example.learning.multipleid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity(name = "COMPANY")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue
    private Long company_seq;

    private String name;

    public Company(String name) {
        this.name = name;
    }
}
