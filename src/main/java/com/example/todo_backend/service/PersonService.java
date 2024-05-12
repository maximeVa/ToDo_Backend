package com.example.todo_backend.service;

// Importing required classes
import com.example.todo_backend.entity.Person;
import java.util.List;

// Interface
public interface PersonService {

  // Save operation
  Person savePerson(Person person);

  // Read operation
  List<Person> fetchPersonList();

  // Update operation
  Person updatePerson(Person person, Long personId);

  // Delete operation
  void deletePersonById(Long personId);
}