package com.denisczwicz.studytestcrud.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String lastName;

    @Column
    @NotBlank
    private String cpf;

    @Column
    @NotNull
    private Integer age;

}
