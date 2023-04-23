package com.parameta.rest.domain.exceptions;

public class DateLaterException extends RuntimeException{

    public DateLaterException() {
        super("La fecha seleccionada es mayor a la actual");
    }
}
