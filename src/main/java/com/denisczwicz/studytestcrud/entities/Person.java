package com.denisczwicz.studytestcrud.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "tb_person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    //@NotBlank
    private String name;

    @Column
    //@NotBlank
    private String lastName;

    @Column
    //@NotBlank
    private String cpf;

    @Column
    //@NotNull
    private Integer age;

}
