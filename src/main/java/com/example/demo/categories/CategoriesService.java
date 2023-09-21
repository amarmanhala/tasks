package com.example.demo.categories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service //Marks class as business service.
public class CategoriesService {

  private List<Categories> categories = Arrays.asList(
    new Categories(1L, "Shirts"),
    new Categories(2L, "Pants")
  );

  public List<Categories> getAllCategories() {
    return categories;
  }

  public Categories getCategoryById(Long id) {
    return categories.stream().filter(c -> c.getId().equals(id)).findFirst().get();
  }

  }
