package com.example.demo.categories;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriesConfig {

  @Bean
  CommandLineRunner commandLineRunner(CategoriesRepository categoriesRepository) {
    return args -> {
      Categories marvin = new Categories(1L, "Testing Marvin");
      Categories alex = new Categories(2L, "Testing ALex");
      Categories amar = new Categories(3L, "Testing Amar");
      Categories simar = new Categories(4L, "Testing Simar");



      categoriesRepository.saveAll(List.of(marvin, alex, amar, simar));

    };
  }
}
