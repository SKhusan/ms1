package com.khusan.ms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CategoryServiceApp {
  public static void main(String[] args) {
    SpringApplication.run(CategoryServiceApp.class, args);
  }
}
