package com.matawan.testvasco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundOperationException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundOperationException(String ex){
        super(ex);
    }
}
