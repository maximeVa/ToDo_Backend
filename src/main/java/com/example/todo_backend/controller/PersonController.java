package com.example.todo_backend.controller;

// Importing required packages/modules

import com.example.todo_backend.entity.Person;
import com.example.todo_backend.service.PersonService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Annotation
@RestController

// Class
public class PersonController {

  @Autowired
  private PersonService personService;

  // Save operation
  @PostMapping("/register")
  public Person savePerson(
      @Valid @RequestBody Person person) {
    return personService.savePerson(person);
  }

  // Read operation
  @GetMapping("/persons")
  public List<Person> fetchPersonList() {
    return personService.fetchPersonList();
  }

  // Update operation
  @PutMapping("/persons/{id}")
  public Person
  updatePerson(@RequestBody Person person,
      @PathVariable("id") Long personId) {
    return personService.updatePerson(
        person, personId);
  }

  // Delete operation
  @DeleteMapping("/persons/{id}")
  public String deletePersonById(@PathVariable("id") Long personId) {
    personService.deletePersonById(personId);
    return "Deleted Successfully";
  }
}

