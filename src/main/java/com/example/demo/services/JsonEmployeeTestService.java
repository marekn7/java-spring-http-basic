package com.example.demo.services;

import com.example.demo.model.EmployeeTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

public class JsonEmployeeTestService implements JsonService{

    public String readJson(String path) throws IOException {

        URL url = new URL(path);

        ObjectMapper objectMapper = new ObjectMapper();

        EmployeeTest emp = objectMapper.readValue(url, EmployeeTest.class);

        return emp.toString();
    }
}
