package com.sangaha.sangahacamera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@PropertySource({"classpath:application.properties", "classpath:application.yml"})
@SpringBootApplication
public class SangahaCameraApplicationTest {
    public static void main(String[] args) {
        SpringApplication.run(SangahaCameraApplicationTest.class, args);
    }
}
