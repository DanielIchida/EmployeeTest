package com.parameta.rest.infraestructure.soap;

import com.parameta.rest.application.repository.EmployeeRepository;
import com.parameta.rest.domain.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEmployeeImpl implements EmployeeRepository {

    @Autowired
    EmployeeClient employeeClient;

    @Override
    public Employee getEmployee(Employee employee) {
        return EmployeeSoapMapper.employeeSoapToemployee(employeeClient.getEmployee(employee).getEmployee());
    }
}
