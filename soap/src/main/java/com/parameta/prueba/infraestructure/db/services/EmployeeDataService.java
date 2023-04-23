package com.parameta.prueba.infraestructure.db.services;

import com.parameta.prueba.application.repositories.EmployeeDataRepository;
import com.parameta.prueba.domain.Employee;
import com.parameta.prueba.infraestructure.db.dao.EmployeeEntityRepository;
import com.parameta.prueba.infraestructure.db.entities.EmployeeEntity;
import com.parameta.prueba.infraestructure.db.mappers.EmployeeEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDataService implements EmployeeDataRepository {

    @Autowired
    EmployeeEntityRepository employeeEntityRepository;

    @Override
    public Employee add(Employee employee) {
        return EmployeeEntityMapper.INSTANCE.entityToDomain(
                employeeEntityRepository.save(EmployeeEntityMapper.INSTANCE.domainToEntity(employee))
        );
    }

    @Override
    public Employee findByDocument(String document) {
        Optional<EmployeeEntity> currentEmployee = employeeEntityRepository.findByDocument(document);
        return currentEmployee.map(EmployeeEntityMapper.INSTANCE::entityToDomain).orElse(null);
    }
}
