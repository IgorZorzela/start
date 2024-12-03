package com.curso.api.start.VO.v2;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PersonVOV2 implements Serializable{
    
    private long Id;    
    private String name;    
    private String lastName;    
    private String address;
    private String gender;
    private Date birthday;
}