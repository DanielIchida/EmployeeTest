package com.parameta.rest.infraestructure.config;

import com.parameta.rest.application.repository.EmployeeRepository;
import com.parameta.rest.application.usescases.GetEmployee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServicesConfig {

    @Bean
    public GetEmployee getEmployee(EmployeeRepository employeeRepository) {
        return new GetEmployee(employeeRepository);
    }


}
