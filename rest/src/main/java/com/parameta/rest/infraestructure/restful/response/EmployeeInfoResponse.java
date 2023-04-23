package com.parameta.rest.infraestructure.restful.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInfoResponse {

    private DateResponse timeOfAssociation;
    private DateResponse age;

}
