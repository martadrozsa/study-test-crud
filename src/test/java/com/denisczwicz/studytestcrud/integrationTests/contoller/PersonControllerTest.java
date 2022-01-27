package com.denisczwicz.studytestcrud.integrationTests.contoller;

import com.denisczwicz.studytestcrud.controllers.dto.PersonDTO;
import com.denisczwicz.studytestcrud.services.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersonService personService;

    @Test
    @DisplayName("Deve salvar a pessoa por meio do Controller")
    public void shouldSavePerson() throws Exception {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(1L);
        personDTO.setName("Frodo");
        personDTO.setLastName("Bolseiro");
        personDTO.setCpf("123456");
        personDTO.setAge(25);

        this.mockMvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personDTO)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
