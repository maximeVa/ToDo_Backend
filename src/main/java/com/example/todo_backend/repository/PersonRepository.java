package com.example.todo_backend.repository;

import com.example.todo_backend.entity.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository

// Interface extending JpaRepository
public interface PersonRepository extends JpaRepository<Person, Long> {

  // Custom method to fetch all persons as a list
  List<Person> findAllBy();
}