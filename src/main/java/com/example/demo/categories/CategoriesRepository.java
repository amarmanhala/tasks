package com.example.demo.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

  boolean existsByName(String name);

}
