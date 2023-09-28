package com.example.demo.categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service // Marks class as business logic or service.
public class CategoriesService {
  private final CategoriesRepository categoriesRepository;
  List<Categories> categoriesList = new ArrayList<>();

  @Autowired
  public CategoriesService(CategoriesRepository categoriesRepository) {
    this.categoriesRepository = categoriesRepository;
  }

  public List<Categories> getAllCategories() {
    return categoriesRepository.findAll();
  }

  public Categories getCategoryById(Long id) {
    return categoriesList.stream().filter(c -> c.getId().equals(id)).findFirst().get();
  }

  public ResponseEntity<Categories> addCategories(@RequestBody Categories categories) {
    boolean isCategoryExists = categoriesRepository.existsByName(categories.getname());
    if (isCategoryExists) {
      return ResponseEntity.notFound().build(); // 404 Not Found if the resource doesn't exist

    } else {
      return ResponseEntity.ok(categoriesRepository.save(categories)); // Return the updated product with a 200 OK
                                                                       // response
    }
  }

  public ResponseEntity<Categories> updateCategory(Categories categories, Long id) {
    // Check if the resource with the given ID exists
    Optional<Categories> existingCategory = categoriesRepository.findById(id);
    if (existingCategory.isPresent()) {
      Categories categoryToBeUpdated = existingCategory.get();
      // Update the product with the new data
      categoryToBeUpdated.setname(categories.getname());
      categoryToBeUpdated.setDescription(categories.getDescription());
      categoryToBeUpdated.setImageUrl(categoryToBeUpdated.getImageUrl());
      categoryToBeUpdated.setIsActive(categoryToBeUpdated.getIsActive());
      // Save the updated product to the database
      Categories savedCategory = categoriesRepository.save(categoryToBeUpdated);

      return ResponseEntity.ok(savedCategory); // Return the updated product with a 200 OK response
    } else {
      return ResponseEntity.notFound().build(); // 404 Not Found if the resource doesn't exist
    }
  }

  public boolean deleteCategory(Long id) {
    // Check if the category exists
    if (!categoriesRepository.existsById(id)) {
      return false;
    } else {
      categoriesRepository.deleteById(id);
      return true;

    }

  }

}
