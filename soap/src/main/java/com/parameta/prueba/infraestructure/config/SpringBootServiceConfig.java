package com.parameta.prueba.infraestructure.config;

import com.parameta.prueba.application.repositories.EmployeeDataRepository;
import com.parameta.prueba.application.usescases.AddEmployee;
import com.parameta.prueba.application.usescases.FindByDocumentEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {

    @Bean
    public AddEmployee addEmployee(EmployeeDataRepository employeeDataRepository) {
        return new AddEmployee(employeeDataRepository);
    }

    @Bean
    public FindByDocumentEmployee findByDocumentEmployee(EmployeeDataRepository employeeDataRepository) {
        return new FindByDocumentEmployee(employeeDataRepository);
    }

}
