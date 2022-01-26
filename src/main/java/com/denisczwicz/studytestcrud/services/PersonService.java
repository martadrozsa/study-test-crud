package com.denisczwicz.studytestcrud.services;

import com.denisczwicz.studytestcrud.entities.Person;

import java.util.List;

public interface PersonService {

    Long create(Person person);

    List<Person> getAll();

    Person getById(Long id);

    void update(Person dto);

    void updateNameById(Long id, String name);

    void deleteById(Long id);
}
