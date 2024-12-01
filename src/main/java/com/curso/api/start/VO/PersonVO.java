package com.curso.api.start.VO;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonVO implements Serializable{
    
    private long Id;    
    private String name;    
    private String lastName;    
    private String address;
    private String gender;
}