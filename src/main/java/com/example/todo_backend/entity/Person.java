package com.example.todo_backend.entity;

// Importing required classes

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Class
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long personId;
  private String username;
  private String email;
  private Boolean password; // Hashed password
  private String roles;
}
