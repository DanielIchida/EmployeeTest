package com.parameta.rest.infraestructure.restful.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EmployeeRequest {

    @NotBlank(message = "Los nombres no deben estar vacio")
    private String name;
    @NotBlank(message = "Los apellidos no deben estar vacio")
    private String lastname;
    @NotBlank(message = "El tipo de documento no debe estar vacio")
    private String typeDocument;
    @NotBlank(message = "El documento no debe estar vacio")
    private String document;
    @NotBlank(message = "la fecha de nacimiento no debe estar vacia")
    private String dateOfBirth;
    @NotBlank(message = "la fecha de ingreso no debe estar vacia")
    private String dateOfAffiliation;
    @NotBlank(message = "El cargo no debe estar vacio")
    private String cargo;
    @DecimalMax(value = "50000.0",message = "El monto maximo deber ser 50000")
    @DecimalMin(value = "500.0",message = "El monto minimo debe ser 500")
    private BigDecimal salary;

}
