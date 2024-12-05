package com.curso.api.start.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.curso.api.start.Controller.PersonController;
import com.curso.api.start.Exceptions.UnsupportedMath;
import com.curso.api.start.Mapper.CustomMapper;
import com.curso.api.start.Mapper.DozerMapper;
import com.curso.api.start.Model.Person;
import com.curso.api.start.Repository.PersonRepository;
import com.curso.api.start.VO.PersonVO;
import com.curso.api.start.VO.v2.PersonVOV2;

@Service
public class PersonService implements Serializable {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    CustomMapper mapper;

    public List<PersonVO> findAll(){
        logger.info("Find all people");                           
        var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
            persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getId())).withSelfRel()));
        return persons;
    }
            
    public PersonVO findById(Long id){
        logger.info("Find person");
        Person person = new Person();		
		person.setName("Leandro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - Minas Gerais - Brasil");
		person.setGender("Male");
		var entity = repository.findById(id)
                            .orElseThrow(() -> new UnsupportedMath("Person not found by ID"));
            var vo = DozerMapper.parseObject(entity, PersonVO.class);
                vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
            return vo;
    }

    public PersonVO create (PersonVO person){
        logger.info("created a person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }     

    public PersonVO update (PersonVO person){
        logger.info("update a person");

        var  entity = repository.findById(person.getId())
                            .orElseThrow(() -> new UnsupportedMath("Person not found by ID"));
                            entity.setName(person.getName());
                            entity.setLastName(person.getLastName());
                            entity.setAddress(person.getAddress());
                            entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getId())).withSelfRel());
        return vo;
    }

    public void delete (Long id){
        logger.info("person deleted");

        var  entity = repository.findById(id)
                            .orElseThrow(() -> new UnsupportedMath("Person not found by ID"));
        repository.delete(entity);        
    }

    public PersonVOV2 createv2 (PersonVOV2 person){
        logger.info("created a person with V2");
        var entity = mapper.convertVOToEntity(person);
        var vo = repository.save(entity);
        return mapper.convertEntityToVO(vo);
    }     
       
}