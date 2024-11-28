package com.curso.api.start.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMath extends RuntimeException{

    public UnsupportedMath(String ex) {
        super(ex);        
    }

    private static final long serialVersionUID = 1L;
}
