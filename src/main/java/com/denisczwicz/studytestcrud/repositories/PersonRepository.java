package com.denisczwicz.studytestcrud.repositories;

import com.denisczwicz.studytestcrud.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByCpf(String cpf);
}
