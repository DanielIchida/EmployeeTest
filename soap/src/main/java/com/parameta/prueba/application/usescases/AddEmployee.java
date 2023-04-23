package com.parameta.prueba.application.usescases;

import com.parameta.prueba.application.repositories.EmployeeDataRepository;
import com.parameta.prueba.domain.Employee;

public class AddEmployee {

    private final EmployeeDataRepository employeeDataRepository;

    public AddEmployee(EmployeeDataRepository employeeDataRepository) {
        this.employeeDataRepository = employeeDataRepository;
    }

    public Employee invoke(Employee employee) {
        return employeeDataRepository.add(employee);
    }
}
