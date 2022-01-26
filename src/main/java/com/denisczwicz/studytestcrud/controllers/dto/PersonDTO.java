package com.denisczwicz.studytestcrud.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private String lastName;
    private String cpf;
    private Integer age;
}
