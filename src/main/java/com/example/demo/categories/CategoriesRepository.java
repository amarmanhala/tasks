package com.example.demo.categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {

  @Query("SELECT c FROM Categories c WHERE c.name = ?1");
  Optional<Categories> findCategoryByName(String name);
  
}
