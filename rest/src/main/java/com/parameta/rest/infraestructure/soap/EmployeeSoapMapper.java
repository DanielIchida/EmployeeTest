package com.parameta.rest.infraestructure.soap;


import com.parameta.rest.domain.entities.Employee;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class EmployeeSoapMapper {

    public static Employee employeeSoapToemployee(com.example.consumingwebservice.wsdl.Employee employeeSoap) {
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

    public static XMLGregorianCalendar convertXmlGregorianCalendar(LocalDate localDate){
        try {
            XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            calendar.setDay(localDate.getDayOfMonth());
            calendar.setMonth(localDate.getMonthValue());
            calendar.setYear(localDate.getYear());
            return calendar;
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }


}
