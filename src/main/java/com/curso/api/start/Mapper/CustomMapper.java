package com.curso.api.start.Mapper;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.curso.api.start.Model.Person;
import com.curso.api.start.VO.v2.PersonVOV2;

@Service
public class CustomMapper {

    public PersonVOV2 convertEntityToVO(Person person){
        PersonVOV2 vo2 = new PersonVOV2();

        vo2.setId(person.getId());
        vo2.setName(person.getName());
        vo2.setLastName(person.getLastName());
        vo2.setAddress(person.getAddress());
        vo2.setBirthday(new Date());       
        vo2.setGender(person.getGender());
        return vo2;
    }

    public Person convertVOToEntity(PersonVOV2 person){
        Person vo = new Person();

        vo.setId(person.getId());
        vo.setName(person.getName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        //vo.setBirthday(new Date());       
        vo.setGender(person.getGender());
        return vo;
    }
}