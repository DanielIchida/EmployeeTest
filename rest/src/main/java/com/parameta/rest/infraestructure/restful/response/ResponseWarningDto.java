package com.parameta.rest.infraestructure.restful.response;

public class ResponseWarningDto  extends ResponseDTO{

    public ResponseDTO drawMessage(String message,Object result) {
        setType(TypeResponse.WARNING);
        setMessage(message);
        setResult(result);
        return this;
    }

}
