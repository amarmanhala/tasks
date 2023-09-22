package com.example.demo.categories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service // Marks class as business logic or service.
public class CategoriesService {
  List<Categories> categoriesList = new ArrayList<>();

  public CategoriesService() {
    this.categoriesList.add(new Categories(1L, "Shirts"));
    this.categoriesList.add(new Categories(2L, "Pants"));
    this.categoriesList.add(new Categories(3L, "Jackets"));

  }

  public List<Categories> getAllCategories() {
    return categoriesList;
  }

  public Categories getCategoryById(Long id) {
    return categoriesList.stream().filter(c -> c.getId().equals(id)).findFirst().get();
  }

  public void addCategories(Categories categories) {
    categoriesList.add(categories);
  }

  public void updateCategory(Categories categories, Long id) {
    for (Categories i: categoriesList) {
      if(i.getId() == id) {
        i.setname("New name");
      }
    }
  }

  public void deleteCategory(Categories categories, Long id) {
    for (Categories i: categoriesList) {
      if(i.getId() == id) {
                i.setname("Deleted");

      }
    }
  }

}
