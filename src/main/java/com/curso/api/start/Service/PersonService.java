package com.curso.api.start.Service;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.api.start.Exceptions.UnsupportedMath;
import com.curso.api.start.Mapper.DozerMapper;
import com.curso.api.start.Model.Person;
import com.curso.api.start.Repository.PersonRepository;
import com.curso.api.start.VO.PersonVO;

@Service
public class PersonService implements Serializable {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll(){
        logger.info("Find all people");                           
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
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
            return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO creat (PersonVO person){
        logger.info("created a person");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = repository.save(entity);
        return DozerMapper.parseObject(vo, PersonVO.class);
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
        return vo;
    }

    public void delete (Long id){
        logger.info("person deleted");

        var  entity = repository.findById(id)
                            .orElseThrow(() -> new UnsupportedMath("Person not found by ID"));
        repository.delete(entity);        
    }
    
       
}