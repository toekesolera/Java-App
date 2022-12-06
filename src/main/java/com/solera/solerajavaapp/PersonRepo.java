package com.solera.solerajavaapp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends CrudRepository<Person, Long> {
    List<Person> findByLastName(String lastName);

    Person findById(long id);
}