package com.parameta.rest.domain.services;


import com.parameta.rest.domain.entities.Employee;
import com.parameta.rest.domain.exceptions.DateLaterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EmployeeServices {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServices.class);


    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final int AGE_MIN = 18;

    private final Employee employee;

    public EmployeeServices(Employee employee) {
        this.employee = employee;
    }

    public Period timeOfAssociation() {
        return calculatePeriod(employee.getDateOfAffiliation());
    }

    public Period age() {
        return calculatePeriod(employee.getDateOfBirth());
    }

    public boolean validateUnderageAge() {
        Period agePeriod = calculatePeriod(employee.getDateOfBirth());
        return agePeriod.getYears() < AGE_MIN;
    }

    private Period calculatePeriod(LocalDate date) {
        LocalDate dateFormat = LocalDate.parse(date.toString(),formatDate());
        if(dateFormat.isAfter(currentDate())){
            throw new DateLaterException();
        }
        return Period.between(dateFormat,currentDate());
    }

    private LocalDate currentDate() {
        return LocalDate.parse(LocalDate.now().toString(),formatDate());
    }

    private DateTimeFormatter formatDate() {
       return DateTimeFormatter.ofPattern(FORMAT_DATE);
    }
}
