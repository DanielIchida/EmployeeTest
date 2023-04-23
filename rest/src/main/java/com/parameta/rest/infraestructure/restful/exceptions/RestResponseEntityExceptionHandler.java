package com.parameta.rest.infraestructure.restful.exceptions;

import com.parameta.rest.domain.exceptions.DateLaterException;
import com.parameta.rest.domain.exceptions.EmployeeUnderageException;
import com.parameta.rest.domain.services.EmployeeServices;
import com.parameta.rest.infraestructure.restful.response.ResponseDTO;
import com.parameta.rest.infraestructure.restful.response.ResponseErrorDto;
import com.parameta.rest.infraestructure.restful.response.ResponseWarningDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            DateLaterException.class ,
            EmployeeUnderageException.class})
    protected ResponseEntity<ResponseDTO> handleWarn(RuntimeException ex, WebRequest webRequest) {
        ResponseWarningDto responseDTO = new ResponseWarningDto();
        responseDTO.drawMessage(ex.getMessage(),null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }

    @ExceptionHandler(value = {Exception.class,RuntimeException.class})
    protected ResponseEntity<ResponseDTO> handleError(RuntimeException ex, WebRequest webRequest) {
        ResponseErrorDto responseDTO = new ResponseErrorDto();
        responseDTO.drawMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    @ExceptionHandler(value = {DateTimeParseException.class})
    protected ResponseEntity<ResponseDTO> handleValidateDate(RuntimeException ex, WebRequest webRequest) {
        ResponseWarningDto responseDTO = new ResponseWarningDto();
        responseDTO.drawMessage(String.format("Formato de Fecha no valida , deberia ser asi %s", EmployeeServices.FORMAT_DATE),null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ResponseWarningDto responseDTO = new ResponseWarningDto();
        for (ObjectError methodArgumentNotValidException : ex.getBindingResult().getAllErrors()){
            errors.add(methodArgumentNotValidException.getDefaultMessage());
        }
        responseDTO.drawMessage("Error en los argumentos",errors);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseDTO);
    }
}
