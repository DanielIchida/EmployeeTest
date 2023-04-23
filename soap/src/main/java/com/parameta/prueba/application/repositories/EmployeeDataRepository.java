package com.parameta.prueba.application.repositories;

import com.parameta.prueba.domain.Employee;

public interface EmployeeDataRepository {
    Employee add(Employee employee);
    Employee findByDocument(String document);
}
