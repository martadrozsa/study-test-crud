package com.denisczwicz.studytestcrud.integrationTests.repository;

import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.repositories.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("A pessoa foi salva pelo repositório")
    public void shouldSavePerson() {

        Person person = new Person();
        person.setName("Frodo");
        person.setName("Frodo");
        person.setLastName("Bolseiro");
        person.setCpf("123456");
        person.setAge(25);

        personRepository.save(person);

        assertThat(person.getId()).isNotNull();
    }
}
