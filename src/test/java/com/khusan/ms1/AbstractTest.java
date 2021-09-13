//package com.khusan.ms1;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.extension.AfterAllCallback;
//import org.junit.jupiter.api.extension.BeforeAllCallback;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//@Slf4j
//@SpringBootTest
//@Testcontainers
//@ExtendWith(SpringExtension.class)
//public abstract class AbstractTest implements BeforeAllCallback, AfterAllCallback {
//
//  private static final MongoDBContainer MONGO_DB_CONTAINER;
//
//  static {
//    MONGO_DB_CONTAINER = new MongoDBContainer("mongodb:latest");
//    MONGO_DB_CONTAINER.start();
//  }
//
//  @Override
//  public void beforeAll(ExtensionContext context) throws Exception {
//    System.setProperty("spring.data.mongodb.host", MONGO_DB_CONTAINER.getHost());
//    System.setProperty(
//        "spring.data.mongodb.port", MONGO_DB_CONTAINER.getFirstMappedPort().toString());
//
//    log.info("Started up Mongo on: {}", MONGO_DB_CONTAINER.getHost());
//  }
//
//  @Override
//  public void afterAll(ExtensionContext context) throws Exception {
//    MONGO_DB_CONTAINER.stop();
//  }
//}
