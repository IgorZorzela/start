package com.curso.api.start.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.api.start.Service.PersonService;
import com.curso.api.start.Util.MediaType;
import com.curso.api.start.VO.PersonVO;
import com.curso.api.start.VO.v2.PersonVOV2;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;   

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON
                                            ,MediaType.APPLICATION_XML
                                            ,MediaType.APPLICATION_YML})
    public PersonVO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON
      ,MediaType.APPLICATION_XML
      ,MediaType.APPLICATION_YML})
    public List<PersonVO> findAll(Long id) {
		return service.findAll();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON
                            ,MediaType.APPLICATION_XML
                            ,MediaType.APPLICATION_YML},
                 consumes = {MediaType.APPLICATION_JSON
                            ,MediaType.APPLICATION_XML
                            ,MediaType.APPLICATION_YML})
    public PersonVO create(@RequestBody PersonVO PersonDTO) {
		return service.create(PersonDTO);
    }

    @PostMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON
                                           ,MediaType.APPLICATION_XML
                                           ,MediaType.APPLICATION_YML},
                                consumes = {MediaType.APPLICATION_JSON
                                           ,MediaType.APPLICATION_XML
                                           ,MediaType.APPLICATION_YML})
public PersonVOV2 createv2(@RequestBody PersonVOV2 PersonDTO) {
return service.createv2(PersonDTO);
}

    @PutMapping(produces = {MediaType.APPLICATION_JSON
                           ,MediaType.APPLICATION_XML
                           ,MediaType.APPLICATION_YML},
                consumes = {MediaType.APPLICATION_JSON
                           ,MediaType.APPLICATION_XML
                           ,MediaType.APPLICATION_YML})
    public PersonVO update(@RequestBody PersonVO PersonDTO) {
		return service.update(PersonDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
      service.delete(id);		
      return ResponseEntity.noContent().build();

    }

}