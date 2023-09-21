package com.example.demo.task;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

  @Bean
  CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
    return args -> {
      Task test1 = new Task(
          "Amar",
          "Amarpreet Singh",
          LocalDate.of(2000, Month.JANUARY, 5),
          "fef");

      Task test2 = new Task(
          "Simar",
          "Harsimarpreet Singh",
          LocalDate.of(2000, Month.JANUARY, 5),
          "fefefefef");

      taskRepository.saveAll(List.of(test1, test2));
    };

  }
}
