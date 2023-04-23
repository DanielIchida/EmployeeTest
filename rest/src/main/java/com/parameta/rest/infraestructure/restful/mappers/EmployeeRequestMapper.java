package com.parameta.rest.infraestructure.restful.mappers;

import com.parameta.rest.domain.entities.Employee;
import com.parameta.rest.infraestructure.restful.request.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

@Mapper
public interface EmployeeRequestMapper {

    EmployeeRequestMapper INSTANCE = Mappers.getMapper(EmployeeRequestMapper.class);

    default Employee employeeToEmployeeRequest(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setLastname(employeeRequest.getLastname());
        employee.setTypeDocument(employeeRequest.getTypeDocument());
        employee.setDocument(employeeRequest.getDocument());
        employee.setDateOfBirth(LocalDate.parse(employeeRequest.getDateOfBirth()));
        employee.setDateOfAffiliation(LocalDate.parse(employeeRequest.getDateOfAffiliation()));
        employee.setCargo(employeeRequest.getCargo());
        employee.setSalary(employeeRequest.getSalary().doubleValue());
        return employee;
    }

}
