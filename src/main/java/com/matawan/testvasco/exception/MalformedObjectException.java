package com.matawan.testvasco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MalformedObjectException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public MalformedObjectException(String ex){
        super(ex);
    }
}
