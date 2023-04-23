package com.parameta.prueba.application.usescases;

import com.parameta.prueba.application.repositories.EmployeeDataRepository;
import com.parameta.prueba.domain.Employee;


public class FindByDocumentEmployee {

    private final EmployeeDataRepository employeeDataRepository;

    public FindByDocumentEmployee(EmployeeDataRepository employeeDataRepository) {
        this.employeeDataRepository = employeeDataRepository;
    }

    public Employee invoke(String document) {
        return employeeDataRepository.findByDocument(document);
    }
}
