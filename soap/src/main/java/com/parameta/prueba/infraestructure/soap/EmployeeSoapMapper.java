package com.parameta.prueba.infraestructure.soap;

import com.parameta.prueba.domain.Employee;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class EmployeeSoapMapper {

    public static Employee employeeSoapToemployee(io.spring.guides.gs_producing_web_service.Employee employeeSoap) {
        Employee employee = new Employee();
        employee.setName(employeeSoap.getName());
        employee.setLastname(employeeSoap.getLastname());
        employee.setTypeDocument(employeeSoap.getTypeDocument().name());
        employee.setDocument(employeeSoap.getDocument());
        employee.setCargo(employeeSoap.getCargo());
        employee.setSalary(employeeSoap.getSalary().doubleValue());
        employee.setDateOfAffiliation(convertLocalDate(employeeSoap.getDateOfAffiliation()));
        employee.setDateOfBirth(convertLocalDate(employeeSoap.getDateOfBirth()));
        return employee;
    }

    private static LocalDate convertLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        return LocalDate.of(xmlGregorianCalendar.getYear(),xmlGregorianCalendar.getMonth(), xmlGregorianCalendar.getDay());
    }


}
