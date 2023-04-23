package com.parameta.rest.infraestructure.restful.response;

public class ResponseErrorDto extends ResponseDTO {
    public ResponseDTO drawMessage(String message) {
        setType(TypeResponse.ERROR);
        setMessage(message);
        setResult(null);
        return this;
    }

}
