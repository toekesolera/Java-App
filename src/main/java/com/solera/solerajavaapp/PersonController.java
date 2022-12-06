package com.solera.solerajavaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepo repo;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String welcome() {
        return "<html><body>" + "<h1>Welcome to the Solera Java App Project.</h1>" + "</body></html";
    }

    @GetMapping("/person")
    public List<Person> getAll() {
        return (List<Person>) repo.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable(value = "id") int id) {
        return repo.findById(id);
    }

    @PostMapping("/person")
    public Person createEmployee(@RequestBody Person person) {
        return personRepository.save(person);
    }


}
