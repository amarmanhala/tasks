package com.example.demo.categories;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Marks class as entity
public class Categories {

  @Id // Marks as PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private String imageUrl;
  private boolean isActive;
  private Date createdAt = new Date();
  private Date updatedAt = new Date();

  public Categories() {
  }
  // Constructor with all attributes
  public Categories(String name, String description, String imageUrl, boolean isActive) {
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.isActive = isActive;
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

  public boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

  public void setCreatedAt() {
    this.createdAt = new Date();
  }

  public void setUpdatedAt() {
    this.updatedAt = new Date();
  }


}
