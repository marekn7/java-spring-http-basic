package com.example.demo.services;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class JsonEmployeeService {

    public String readData(String path) throws IOException {

        URL url = new URL(path);

        ObjectMapper objectMapper = new ObjectMapper();

        Employee emp = objectMapper.readValue(url, Employee.class);

        return emp.toString();
    }
}
