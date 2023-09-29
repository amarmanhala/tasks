package com.example.demo.categories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriesController {

  @Autowired // Marks as dependency injection
  private CategoriesService categoriesService;

  @RequestMapping("/categories") // Default Get: Request
  public List<Categories> getCategories() {
    return categoriesService.getAllCategories();
  }

  @RequestMapping("/categories/{id}")
  public Categories getCategoryById(@PathVariable Long id) {
    return categoriesService.getCategoryById(id);
  }

  @PostMapping("/categories")
  public ResponseEntity<Categories> addCategories(@RequestBody Categories categories) {
    ResponseEntity<Categories> responseEntity = categoriesService.addCategories(categories);

    // You can directly return the response from the service method
    return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
  }

  @PutMapping("/categories/{id}")
  public ResponseEntity<?> updateCategory(@RequestBody Categories categories, @PathVariable Long id) {
    Optional<Categories> updatedCategoryOptional = categoriesService.updateCategory(categories, id);

    if (updatedCategoryOptional.isPresent()) {
        Categories updatedCategory = updatedCategoryOptional.get();
        return ResponseEntity.ok(updatedCategory); // 200 OK with the updated category
    } else {
        return ResponseEntity.notFound().build(); // 404 Not Found when category not found
    }
}
    

  @DeleteMapping("/categories/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    boolean isDeleted = categoriesService.deleteCategory(id);
    // Use ternary operator for concise ResponseEntity creation
    return isDeleted
        ? ResponseEntity.noContent().build() // Successful deletion
        : ResponseEntity.notFound().build(); // Resource not found
  }

}
