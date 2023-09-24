package com.example.demo.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
  public void updateCategory(@RequestBody Categories categories, @PathVariable Long id) {
    categoriesService.updateCategory(categories, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
  public void deleteCategory(@RequestBody Categories categories, @PathVariable Long id) {
    categoriesService.deleteCategory(categories, id);
  }

  @RequestMapping("/categories/count")
  public int countCategories() {
return 1;  }


}
