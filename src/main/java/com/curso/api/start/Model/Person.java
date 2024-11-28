package com.curso.api.start.Model;

import java.io.Serializable;



import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private long Id;
    private String name;
    private String lastName;
    private String address;
    private String gender;
}