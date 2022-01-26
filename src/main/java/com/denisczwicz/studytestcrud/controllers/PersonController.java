package com.denisczwicz.studytestcrud.controllers;

import com.denisczwicz.studytestcrud.controllers.dto.PersonDTO;
import com.denisczwicz.studytestcrud.controllers.mapper.PersonDTOMapper;
import com.denisczwicz.studytestcrud.entities.Person;
import com.denisczwicz.studytestcrud.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void update(@RequestBody PersonDTO personDTO) {

    }

    @PatchMapping
    public void updateNameById(@RequestParam Long id, @RequestParam String name) {

    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {

    }

}
