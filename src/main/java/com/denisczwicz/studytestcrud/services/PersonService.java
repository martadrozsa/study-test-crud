package com.denisczwicz.studytestcrud.services;

import com.denisczwicz.studytestcrud.entities.Person;

import java.util.List;

public interface PersonService {

    Person insert(Person person);

    List<Person> findAll();

    Person findById(Long id);

    Person update(Long id, Person dto);

    void deleteById(Long id);


}
