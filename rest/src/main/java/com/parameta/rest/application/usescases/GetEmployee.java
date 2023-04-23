package com.parameta.rest.application.usescases;

import com.parameta.rest.application.repository.EmployeeRepository;
import com.parameta.rest.domain.entities.Employee;
import com.parameta.rest.domain.exceptions.EmployeeUnderageException;
import com.parameta.rest.domain.services.EmployeeServices;

public class GetEmployee {

    private EmployeeRepository employeeRepository;

    public GetEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee invoke(Employee employee) {
        EmployeeServices services = new EmployeeServices(employee);
        if(services.validateUnderageAge()) {
           throw new EmployeeUnderageException();
        }
        return employeeRepository.getEmployee(employee);
    }
}
