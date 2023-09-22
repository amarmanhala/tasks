package com.example.demo.categories;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //Marks class as entity
public class Categories {

  @Id //Marks as PRIMARY KEY
  private Long id;
  private String name;
  private String description;
  private String imageUrl;
  private boolean isActive;
  private Date createdAt;
  private Date updatedAt;

  public Categories(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

}
