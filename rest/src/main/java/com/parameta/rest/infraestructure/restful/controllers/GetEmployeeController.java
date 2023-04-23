package com.parameta.rest.infraestructure.restful.controllers;

import com.parameta.rest.application.usescases.AgeEmployee;
import com.parameta.rest.application.usescases.GetEmployee;
import com.parameta.rest.application.usescases.TimeOfAssociationEmployee;
import com.parameta.rest.domain.entities.Employee;
import com.parameta.rest.domain.services.EmployeeServices;
import com.parameta.rest.infraestructure.restful.mappers.EmployeeRequestMapper;
import com.parameta.rest.infraestructure.restful.request.EmployeeRequest;
import com.parameta.rest.infraestructure.restful.response.DateResponse;
import com.parameta.rest.infraestructure.restful.response.EmployeeInfoResponse;
import com.parameta.rest.infraestructure.restful.response.ResponseDTO;
import com.parameta.rest.infraestructure.restful.response.ResponseOKDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;

@RestController
@RequestMapping("employee")
public class GetEmployeeController {

    @Autowired
    private GetEmployee getEmployee;

    @GetMapping
    public ResponseEntity<ResponseDTO> getEmployee(@Valid EmployeeRequest employeeRequest) {
        Employee currentEmployee = getEmployee.invoke(EmployeeRequestMapper.INSTANCE.employeeToEmployeeRequest(employeeRequest));
        TimeOfAssociationEmployee timeOfAssociationEmployee = new TimeOfAssociationEmployee(new EmployeeServices(currentEmployee));
        AgeEmployee ageEmployee = new AgeEmployee(new EmployeeServices(currentEmployee));
        ResponseOKDto response = new ResponseOKDto();
        EmployeeInfoResponse employeeInfoResponse = buildInfo(
                buildDate(timeOfAssociationEmployee.invoke(currentEmployee)),
                buildDate(ageEmployee.invoke(currentEmployee))
        );
        response.drawMessage(employeeInfoResponse);
        return ResponseEntity.ok(response);
    }

    private DateResponse buildDate(Period period) {
        DateResponse dateResponse = new DateResponse();
        dateResponse.setDay(period.getDays());
        dateResponse.setMoth(period.getMonths());
        dateResponse.setYear(period.getYears());
        return dateResponse;
    }

    private EmployeeInfoResponse buildInfo(DateResponse association,DateResponse age){
        EmployeeInfoResponse employeeInfoResponse = new EmployeeInfoResponse();
        employeeInfoResponse.setAge(age);
        employeeInfoResponse.setTimeOfAssociation(association);
        return employeeInfoResponse;
    }

}
