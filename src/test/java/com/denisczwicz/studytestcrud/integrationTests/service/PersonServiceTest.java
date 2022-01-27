package com.denisczwicz.studytestcrud.integrationTests.service;

import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.repositories.PersonRepository;
import com.denisczwicz.studytestcrud.services.PersonService;
import com.denisczwicz.studytestcrud.services.impl.PersonServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@SpringBootTest
public class PersonServiceTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    @Captor
    private ArgumentCaptor<Person> personArgumentCaptor;

    @Test
    @DisplayName("A pessoa foi salva")
    public void shouldSavePerson(){

        Person person = new Person();
        person.setId(1L);
        person.setName("Frodo");
        person.setLastName("Bolseiro");
        person.setCpf("123456");
        person.setAge(25);

        personService.insert(person);

        verify(personRepository).save(personArgumentCaptor.capture());
        Person saved = personArgumentCaptor.getValue();
        assertThat(saved).isNotNull();
        assertThat(saved).isEqualTo(person);
    }
}
