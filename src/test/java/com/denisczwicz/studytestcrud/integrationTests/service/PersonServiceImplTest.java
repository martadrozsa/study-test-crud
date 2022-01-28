package com.denisczwicz.studytestcrud.integrationTests.service;

import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.repositories.PersonRepository;
import com.denisczwicz.studytestcrud.services.impl.PersonServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl personService;

    @Test
    @DisplayName("A pessoa foi salva pelo service")
    public void shouldSavePerson() {

        Person person = new Person();
        person.setName("Frodo");
        person.setName("Frodo");
        person.setLastName("Bolseiro");
        person.setCpf("123456");
        person.setAge(25);

        personService.insert(person);

        assertThat(person.getId()).isNotNull();
    }
}
