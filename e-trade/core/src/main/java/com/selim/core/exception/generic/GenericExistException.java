package com.selim.core.exception.generic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericExistException extends RuntimeException {

    public GenericExistException(String message) {
        super(message);
    }
}