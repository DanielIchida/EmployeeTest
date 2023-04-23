package com.parameta.rest.domain.exceptions;

public class EmployeeUnderageException extends RuntimeException{

    public EmployeeUnderageException() {
        super("No se puede registrar un empleado menor de edad");
    }
}
