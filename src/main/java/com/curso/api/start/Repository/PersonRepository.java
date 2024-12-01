package com.curso.api.start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.api.start.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
