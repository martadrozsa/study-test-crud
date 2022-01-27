package com.denisczwicz.studytestcrud.services.impl;

import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.repositories.PersonRepository;
import com.denisczwicz.studytestcrud.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Person findById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        Person person = personOptional.get();
        return person;
    }

    @Transactional
    @Override
    public Person insert(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    @Override
    public Person update(Long id, Person person) {
        Person savedPerson = personRepository.getById(id);
        savedPerson.setName(person.getName());
        return personRepository.save(savedPerson);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
