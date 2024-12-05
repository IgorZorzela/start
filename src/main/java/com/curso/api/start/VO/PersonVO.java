package com.curso.api.start.VO;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import lombok.Data;

@Data
@JsonPropertyOrder({"id", "name", "last_name", "address", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable{
    
    
    private Long id;    
    private String name;    
    @JsonProperty("last_name")
    private String lastName;    
    private String address;
    @JsonIgnore
    private String gender;    
    
}