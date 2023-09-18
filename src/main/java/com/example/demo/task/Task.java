package com.example.demo.task;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
      name = "task_sequence",
      sequenceName = "task_sequence",
      allocationSize = 1
    )

  private Long id;
  private String name;
  private String description;
  private LocalDate created_on;
  private String status;

  public Task(Long id, String name, String description, LocalDate created_on, String status) {
    

    this.id = id;
    this.name = name;
    this.description = description;
    this.created_on = created_on;
    this.status = status;
  }

  public Task(String name, String description, LocalDate created_on, String status) {
    this.name = name;
    this.description = description;
    this.created_on = created_on;
    this.status = status;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreatedOn() {
    return this.created_on;
  }

  public void setCreatedOn(LocalDate created_on) {
    this.created_on = created_on;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
