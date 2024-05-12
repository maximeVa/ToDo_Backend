package com.example.todo_backend.service;

// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todo_backend.entity.Person; // Importing the Person entity class
import com.example.todo_backend.repository.PersonRepository; // Importing the Person repository

// Annotation
@Service

// Class
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  // Save operation
  @Override
  public Person savePerson(Person person) {
    return personRepository.save(person);
  }

  // Read operation
  @Override
  public List<Person> fetchPersonList() {
    return personRepository.findAll();
  }

  // Update operation
  @Override
  public Person updatePerson(Person person, Long personId) {
    Person personDB = personRepository.findById(personId).orElse(null);

    if (personDB != null) {
      if (Objects.nonNull(person.getUsername()) && !"".equals(person.getUsername())) {
        personDB.setUsername(person.getUsername());
      }
      if (Objects.nonNull(person.getEmail()) && !"".equals(person.getEmail())) {
        personDB.setEmail(person.getEmail());
      }
      if (Objects.nonNull(person.getPassword())) {
        personDB.setPassword(person.getPassword());
      }
      if (Objects.nonNull(person.getRoles()) && !"".equals(person.getRoles())) {
        personDB.setRoles(person.getRoles());
      }
      return personRepository.save(personDB);
    } else {
      return null; // or throw an exception indicating that the person with given id was not found
    }
  }

  // Delete operation
  @Override
  public void deletePersonById(Long personId) {
    personRepository.deleteById(personId);
  }
}

