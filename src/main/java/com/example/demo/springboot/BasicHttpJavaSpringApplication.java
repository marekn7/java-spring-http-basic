package com.example.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan("com.example.demo")
public class BasicHttpJavaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicHttpJavaSpringApplication.class, args);
    }
}
