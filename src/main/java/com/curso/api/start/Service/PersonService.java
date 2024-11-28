package com.curso.api.start.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.curso.api.start.Model.Person;

@Service
public class PersonService implements Serializable {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Find all people");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);                        
        }            
        return persons;
    }
            
    public Person findById(String id){
        logger.info("Find person");
        Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - Minas Gerais - Brasil");
		person.setGender("Male");
		return person;
    }

    public Person creat (Person person){
        logger.info("created a person");
        return person;
    } 
    public Person update (Person person){
        logger.info("update a person");
        return person;
    }

    public void delete (String id){
        logger.info("person deleted");
        
    }

    private Person mockPerson(int i) {        
        Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setName("Person name " + i);
		person.setLastName("Persons last name " + i);
		person.setAddress(" Person address " + i);
		person.setGender("Person gender " + i);
		return person;
    }
       
}