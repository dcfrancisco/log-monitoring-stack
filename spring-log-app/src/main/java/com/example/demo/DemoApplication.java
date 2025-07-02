package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void runOnStartup() throws InterruptedException {
        logger.info("Spring Boot App started.");
        Thread.sleep(1000);
        logger.error("Critical error occurred!");
        Thread.sleep(1000);
        logger.warn("Just a warning.");
        logger.info("Spring Boot App completed.");
    }
}
