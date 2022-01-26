package com.denisczwicz.studytestcrud.controllers.mapper;

import com.denisczwicz.studytestcrud.controllers.dto.PersonDTO;
import com.denisczwicz.studytestcrud.entities.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonDTOMapper {

    Person mapPersonDTOToPerson(PersonDTO personDTO);

    PersonDTO mapPersonToPersonDTO(Person person);

    List<PersonDTO> mapPersonsToPersonsDTO(List<Person> personList);
}
