package com.curso.api.start.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UnsupportedMath extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UnsupportedMath(String ex) {
        super(ex);        
    }    
}