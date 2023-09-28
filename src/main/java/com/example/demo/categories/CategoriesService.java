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
    Optional<Categories> existingCategoryOptional = categoriesRepository.findById(id);

    if (existingCategoryOptional.isPresent()) {
      Categories existingCategory = existingCategoryOptional.get();

      // Update the fields with the new data
      existingCategory.setname(categories.getname());
      existingCategory.setDescription(categories.getDescription());
      existingCategory.setImageUrl(categories.getImageUrl());
      existingCategory.setIsActive(categories.getIsActive()); // Update isActive field

      // Save the updated category to the database
      Categories updatedCategory = categoriesRepository.save(existingCategory);

      return ResponseEntity.ok(updatedCategory); // Return the updated category with a 200 OK response
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
