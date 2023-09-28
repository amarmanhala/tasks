package com.example.demo.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping(method = RequestMethod.POST, value = "/categories")
  public void addCategories(@RequestBody Categories categories) {
    categoriesService.addCategories(categories);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
  public ResponseEntity<Categories> updateCategory(@RequestBody Categories categories, @PathVariable Long id) {

    ResponseEntity<Categories> responseEntity = categoriesService.updateCategory(categories, id);
    if (responseEntity.getStatusCode() == HttpStatus.OK) {
      return ResponseEntity.ok(responseEntity.getBody()); // Forward the 200 OK response with the updated product
    } else {
      return ResponseEntity.status(responseEntity.getStatusCode()).build(); // Return the received status code (e.g.,
                                                                            // 404)
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    boolean isDeleted = categoriesService.deleteCategory(id);
    if (isDeleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Successful deletion
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Resource not found
    }
  }

  @RequestMapping("/categories/count")
  public int countCategories() {
    return 1;
  }

}
