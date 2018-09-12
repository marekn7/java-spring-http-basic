package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeTest {

    private String name;
    private String role;
    private String city;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Role: " + this.role + " City: " + this.city;
    }
}
