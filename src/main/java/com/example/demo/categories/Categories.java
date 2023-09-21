package com.example.demo.categories;

public class Categories {

  private Long id;
  private String categoryName;

  public Categories(Long id, String categoryName) {
    this.id = id;
    this.categoryName = categoryName;
  }

  public Categories(String categoryName) {
    this.categoryName = categoryName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

}
