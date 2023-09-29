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

  public Optional<Categories> getCategoryById(Long id) {

    // Check if the category exists
    if (categoriesRepository.existsById(id)) {
      Optional<Categories> existingCategoryOptional = categoriesRepository.findById(id);
      return existingCategoryOptional; // Return the updated category
    } else {

      return Optional.empty();
    }
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

  public Optional<Categories> updateCategory(Categories categories, Long id) {
    Optional<Categories> existingCategoryOptional = categoriesRepository.findById(id);

    if (existingCategoryOptional.isPresent()) {
      Categories existingCategory = existingCategoryOptional.get();

      existingCategory.setname(categories.getname());
      existingCategory.setDescription(categories.getDescription());
      existingCategory.setImageUrl(categories.getImageUrl());
      existingCategory.setIsActive(categories.getIsActive());

      Categories updatedCategory = categoriesRepository.save(existingCategory);

      return Optional.of(updatedCategory); // Return the updated category
    } else {
      return Optional.empty(); // Indicate that the category was not found
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
