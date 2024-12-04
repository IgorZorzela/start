package com.curso.api.start.VO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"id", "name", "last_name", "address", "gender"})
public class PersonVO implements Serializable{
    
    private long Id;    
    private String name;    
    @JsonProperty("last_name")
    private String lastName;    
    private String address;
    @JsonIgnore
    private String gender;
}