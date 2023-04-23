package com.parameta.prueba.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Employee {

    private String name;
    private String lastname;
    private String typeDocument;
    private String document;
    private LocalDate dateOfBirth;
    private LocalDate dateOfAffiliation;
    private String cargo;
    private double salary;

}
