package com.curso.api.start.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.start.Model.Person;
import com.curso.api.start.Service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;   

    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) {
		return service.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(String id) {
		return service.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, 
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
		return service.creat(person);
    }

    @RequestMapping(method=RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
		return service.update(person);
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public  void delete(@PathVariable(value = "id") String id) {
      service.delete(id);		

    }

}