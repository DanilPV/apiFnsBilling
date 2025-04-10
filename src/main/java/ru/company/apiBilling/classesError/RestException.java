package ru.company.apiBilling.classesError;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestException extends RuntimeException {

    private final HttpStatus httpStatus;

    public RestException(String message, HttpStatus status) {

        super(message);
        httpStatus = status;

    }
}