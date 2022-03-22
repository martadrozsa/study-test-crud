package com.denisczwicz.studytestcrud.controllers;

import com.denisczwicz.studytestcrud.controllers.dto.PersonDTO;
import com.denisczwicz.studytestcrud.controllers.mapper.PersonDTOMapper;
import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    private final PersonDTOMapper personDTOMapper;

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<Person> personsList = personService.findAll();
        List<PersonDTO> personDTOList = personDTOMapper.mapPersonsToPersonsDTO(personsList);
        return ResponseEntity.ok().body(personDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        Person person = personService.findById(id);
        PersonDTO personDTO = personDTOMapper.mapPersonToPersonDTO(person);
        return ResponseEntity.ok().body(personDTO);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO personDTO) {
        Person person = personDTOMapper.mapPersonDTOToPerson(personDTO);
        personService.insert(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person person = personDTOMapper.mapPersonDTOToPerson(personDTO);
        Person personUpdated = personService.update(id, person);
        PersonDTO categoryDTOUpdated = personDTOMapper.mapPersonToPersonDTO(personUpdated);

        return ResponseEntity.ok().body(categoryDTOUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
