package com.test.dettd04.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CodigoPostalNotFoundException extends RuntimeException {
    public CodigoPostalNotFoundException(String message) {
        super(message);
    }
}
