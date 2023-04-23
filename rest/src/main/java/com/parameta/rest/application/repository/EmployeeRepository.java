package com.parameta.rest.application.repository;

import com.parameta.rest.domain.entities.Employee;

public interface EmployeeRepository {
    Employee getEmployee(Employee employee);
}
