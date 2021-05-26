package com.app.netris.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class IdInvalidSupportException extends RuntimeException{
    public IdInvalidSupportException(String message) {
        super(message);
    }
}
