package com.parameta.rest.application.usescases;

import com.parameta.rest.domain.entities.Employee;
import com.parameta.rest.domain.services.EmployeeServices;

import java.time.Period;

public class AgeEmployee {
    private final EmployeeServices employeeServices;

    public AgeEmployee(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    public Period invoke(Employee employee) {
        return employeeServices.age();
    }
}
