package com.parameta.prueba.infraestructure.db.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long id;
    private String name;
    private String lastname;
    @Column(name = "type_document")
    private String typeDocument;
    private String document;
    @Column(name = "data_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "data_of_affiliation")
    private LocalDate dateOfAffiliation;
    private String cargo;
    private double salary;


}
