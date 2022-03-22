package com.denisczwicz.studytestcrud.controllers.mapper;

import com.denisczwicz.studytestcrud.controllers.dto.PersonDTO;
import com.denisczwicz.studytestcrud.entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-14T15:54:14-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Azul Systems, Inc.)"
)
@Component
public class PersonDTOMapperImpl implements PersonDTOMapper {

    @Override
    public Person mapPersonDTOToPerson(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDTO.getId() );
        person.setName( personDTO.getName() );
        person.setLastName( personDTO.getLastName() );
        person.setCpf( personDTO.getCpf() );
        person.setAge( personDTO.getAge() );

        return person;
    }

    @Override
    public PersonDTO mapPersonToPersonDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setName( person.getName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setCpf( person.getCpf() );
        personDTO.setAge( person.getAge() );

        return personDTO;
    }

    @Override
    public List<PersonDTO> mapPersonsToPersonsDTO(List<Person> personList) {
        if ( personList == null ) {
            return null;
        }

        List<PersonDTO> list = new ArrayList<PersonDTO>( personList.size() );
        for ( Person person : personList ) {
            list.add( mapPersonToPersonDTO( person ) );
        }

        return list;
    }
}
