package com.parameta.rest.infraestructure.soap;

import com.example.consumingwebservice.wsdl.GetEmployeeRequest;
import com.example.consumingwebservice.wsdl.GetEmployeeResponse;
import com.example.consumingwebservice.wsdl.TypeDocument;
import com.parameta.rest.domain.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.math.BigDecimal;

public class EmployeeClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(EmployeeClient.class);

    public GetEmployeeResponse getEmployee(Employee employee) {
        GetEmployeeRequest request = new GetEmployeeRequest();
        request.setName(employee.getName());
        request.setLastname(employee.getLastname());
        request.setDocument(employee.getDocument());
        request.setTypeDocument(TypeDocument.valueOf(employee.getTypeDocument()));
        request.setSalary(BigDecimal.valueOf(employee.getSalary()));
        request.setCargo(employee.getCargo());
        request.setDateOfAffiliation(EmployeeSoapMapper.convertXmlGregorianCalendar(employee.getDateOfAffiliation()));
        request.setDateOfBirth(EmployeeSoapMapper.convertXmlGregorianCalendar(employee.getDateOfBirth()));
        log.info(String.format("Request employee %s",request.getDocument()));
        log.info(String.format("Request employee %s",request.getDateOfAffiliation()));
        log.info(String.format("Request employee %s",request.getDateOfBirth()));

        return ( GetEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/employees", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetEmployeeRequest"));
    }

}
