package com.example.demo.categories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service // Marks class as business logic or service.
public class CategoriesService {
  private final CategoriesRepository categoriesRepository;
  List<Categories> categoriesList = new ArrayList<>();

  @Autowired
  public CategoriesService(CategoriesRepository categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
    this.categoriesList.add(new Categories(1L, "Shirts"));
    this.categoriesList.add(new Categories(2L, "Pants"));
    this.categoriesList.add(new Categories(3L, "Jackets"));

  }

  public List<Categories> getAllCategories() {
    return categoriesRepository.findAll();
  }

  public Categories getCategoryById(Long id) {
    return categoriesList.stream().filter(c -> c.getId().equals(id)).findFirst().get();
  }

  

  public void addCategories(@RequestBody Categories categories) {
    categoriesRepository.findCategoryByName(categories.getname());
    if()
    categoriesRepository.findAll();
  }

  public void updateCategory(Categories categories, Long id) {
    for (Categories i : categoriesList) {
      if (i.getId() == id) {
        i.setname("New name");
      }
    }
  }

  public void deleteCategory(Categories categories, Long id) {
    for (Categories i : categoriesList) {
      if (i.getId() == id) {
        i.setname("Deleted");
      }
    }
  }

}
