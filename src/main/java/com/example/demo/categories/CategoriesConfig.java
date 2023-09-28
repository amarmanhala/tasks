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
      Categories marvin = new Categories("Testing Marvi","fefefe","dwdedede", true);
      


      categoriesRepository.saveAll(List.of(marvin));

    };
  }
}
