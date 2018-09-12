package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class Employee {

    private int id;
    private String name;
    private boolean pernament;
    private Address address;
    private long[] phoneNumbers;
    private String role;
    private List<String> cities;
    private Map<String, String> properties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPernament() {
        return pernament;
    }

    public void setPernament(boolean pernament) {
        this.pernament = pernament;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(long[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h3>Employee Details </h3>");

        sb.append("ID: "+getId()+"</br>");
        sb.append("Name: <b>"+getName()+"</b></br></br>");
        sb.append("Permanent: "+isPernament()+"</br>");
        sb.append("Role: "+getRole()+"\n");
        sb.append("Phone Numbers: "+ Arrays.toString(getPhoneNumbers())+"</br>");
        sb.append("Address: "+getAddress()+"</br>");
        sb.append("Cities: "+Arrays.toString(getCities().toArray())+"</br>");
        sb.append("Properties: "+getProperties()+"</br>");

        return sb.toString();
    }
}
