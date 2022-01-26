package com.denisczwicz.studytestcrud.services;

import com.denisczwicz.studytestcrud.entities.Person;

import java.util.List;

public interface PersonService {

    Person insert(Person person);

    List<Person> findAll();

    Person findById(Long id);

    void update(Person dto);

    void updateNameById(Long id, String name);

    void deleteById(Long id);


}
