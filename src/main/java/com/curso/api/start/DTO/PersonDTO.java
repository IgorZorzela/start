package com.curso.api.start.DTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonDTO implements Serializable{
    
    private long Id;    
    private String name;    
    private String lastName;    
    private String address;
    private String gender;
}