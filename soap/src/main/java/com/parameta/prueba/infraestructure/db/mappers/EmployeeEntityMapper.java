package com.parameta.prueba.infraestructure.db.mappers;

import com.parameta.prueba.domain.Employee;
import com.parameta.prueba.infraestructure.db.entities.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeEntityMapper {

    EmployeeEntityMapper INSTANCE = Mappers.getMapper(EmployeeEntityMapper.class);

    default Employee entityToDomain(EmployeeEntity employeeEntity) {
        Employee employee = new Employee();
        employee.setName(employeeEntity.getName());
        employee.setLastname(employeeEntity.getLastname());
        employee.setCargo(employeeEntity.getCargo());
        employee.setDocument(employeeEntity.getDocument());
        employee.setSalary(employeeEntity.getSalary());
        employee.setTypeDocument(employeeEntity.getTypeDocument());
        employee.setDateOfAffiliation(employeeEntity.getDateOfAffiliation());
        employee.setDateOfBirth(employeeEntity.getDateOfBirth());
        return employee;
    }

    default EmployeeEntity domainToEntity(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();;
        employeeEntity.setName(employee.getName());
        employeeEntity.setLastname(employee.getLastname());
        employeeEntity.setCargo(employee.getCargo());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setDocument(employee.getDocument());
        employeeEntity.setTypeDocument(employee.getTypeDocument());
        employeeEntity.setDateOfAffiliation(employee.getDateOfAffiliation());
        employeeEntity.setDateOfBirth(employee.getDateOfBirth());
        return employeeEntity;
    }

}
