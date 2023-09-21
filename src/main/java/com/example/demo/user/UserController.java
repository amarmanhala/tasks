package com.example.demo.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @RequestMapping("/user") //Default: GET
  public List<User> response() {
    return Arrays.asList(
      new User(1L, "Amarpreet Singh"),
      new User(2L, "Amarpreet")
    );
  }
}