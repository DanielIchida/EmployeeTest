package com.parameta.prueba.infraestructure.soap;

import com.parameta.prueba.application.usescases.AddEmployee;
import com.parameta.prueba.application.usescases.FindByDocumentEmployee;
import io.spring.guides.gs_producing_web_service.Employee;
import io.spring.guides.gs_producing_web_service.GetEmployeeRequest;
import io.spring.guides.gs_producing_web_service.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndPoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @Autowired
    private AddEmployee addEmployee;

    @Autowired
    private FindByDocumentEmployee findByDocumentEmployee;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse saveEmployee(@RequestPayload GetEmployeeRequest employeeRequest) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setLastname(employeeRequest.getLastname());
        employee.setTypeDocument(employeeRequest.getTypeDocument());
        employee.setDocument(employeeRequest.getDocument());
        employee.setDateOfAffiliation(employeeRequest.getDateOfAffiliation());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setCargo(employeeRequest.getCargo());
        employee.setSalary(employeeRequest.getSalary());
        response.setEmployee(employee);
        if(findByDocumentEmployee.invoke(employeeRequest.getDocument()) == null) {
           addEmployee.invoke(EmployeeSoapMapper.employeeSoapToemployee(employee));
        }
        return response;
    }

}
