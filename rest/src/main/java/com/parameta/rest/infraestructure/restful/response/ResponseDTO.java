package com.parameta.rest.infraestructure.restful.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseDTO {

    private TypeResponse type;
    private String message;
    private LocalDateTime time;
    private Object result;

    public LocalDateTime getTime() {
        return LocalDateTime.now();
    }
}
