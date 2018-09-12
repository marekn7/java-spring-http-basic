package com.example.demo.config;

import com.example.demo.services.JsonEmployeeService;
import com.example.demo.services.JsonEmployeeTestService;
import com.example.demo.services.JsonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig {

    @Bean(name = "employee")
    public JsonService jsonEmployeeService() {
        return new JsonEmployeeService();
    }

    @Bean(name = "employeeTest")
    public JsonService jsonEmployeeTestService() {
        return new JsonEmployeeTestService();
    }
}
