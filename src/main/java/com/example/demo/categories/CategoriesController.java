package com.example.demo.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {
  
  @Autowired //Marks as dependency injection
  private CategoriesService categoriesService;

  @RequestMapping("/categories")
  public List<Categories> getCategories() {
    return categoriesService.getAllCategories();
  }
 
  @RequestMapping("/categories/{id}")
  public Categories getCategoryById(@PathVariable Long id) {
    return categoriesService.getCategoryById(id);
  }
}
