package com.denisczwicz.studytestcrud.unitaryTests.service;

import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.repositories.PersonRepository;
import com.denisczwicz.studytestcrud.services.impl.PersonServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(SpringExtension.class)
public class PersonServiceImplTest {

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
