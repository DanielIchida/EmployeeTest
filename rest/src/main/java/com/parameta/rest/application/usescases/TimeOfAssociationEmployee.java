package com.parameta.rest.application.usescases;

import com.parameta.rest.domain.entities.Employee;
import com.parameta.rest.domain.services.EmployeeServices;

import java.time.Period;

public class TimeOfAssociationEmployee {

    private final EmployeeServices employeeServices;

    public TimeOfAssociationEmployee(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    public Period invoke(Employee employee) {
        return employeeServices.timeOfAssociation();
    }
}
