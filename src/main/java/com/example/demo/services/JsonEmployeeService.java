package com.example.demo.services;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonEmployeeService implements JsonService {


    public String readJson(String data) throws IOException {


        URL url = new URL(data);

        JsonParser jsonParser = new JsonFactory().createParser(url);

        Employee emp = new Employee();
        Address address = new Address();

        emp.setAddress(address);
        emp.setCities(new ArrayList<>());
        emp.setProperties(new HashMap<>());
        List<Long> phoneNums = new ArrayList<>();
        boolean insidePropertiesObj = false;

        parseJSON(jsonParser, emp, phoneNums, insidePropertiesObj);

        long[] nums = new long[phoneNums.size()];
        int index = 0;
        for (Long l : phoneNums) {
            nums[index++] = l;
        }
        emp.setPhoneNumbers(nums);

        jsonParser.close();

        return emp.toString();
    }



    private static void parseJSON(JsonParser jsonParser, Employee emp, List<Long> phoneNums, boolean insidePropertiesObj)
            throws JsonParseException, IOException {

        //loop throught the JsonTocken
        while(jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String name = jsonParser.getCurrentName();
            if ("id".equals(name)) {
                jsonParser.nextToken();
                emp.setId(jsonParser.getIntValue());
            } else if ("name".equals(name)){
                jsonParser.nextToken();
                emp.setName(jsonParser.getText());
            } else if ("pernament".equals(name)) {
                jsonParser.nextToken();
                emp.setPernament(jsonParser.getBooleanValue());
            } else if ("address".equals(name)) {
                jsonParser.nextToken();
                //rekurzivni volani
                parseJSON(jsonParser, emp, phoneNums, insidePropertiesObj);
            } else if ("street".equals(name)) {
                jsonParser.nextToken();
                emp.getAddress().setStreet(jsonParser.getText());
            } else if ("city".equals(name)) {
                jsonParser.nextToken();
                emp.getAddress().setCity(jsonParser.getText());
            } else if ("zipcode".equals(name)) {
                jsonParser.nextToken();
                emp.getAddress().setZipcode(jsonParser.getIntValue());

            } else if ("phoneNumbers".equals(name)) {
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    phoneNums.add(jsonParser.getLongValue());
                }

            } else if("role".equals(name)){
                jsonParser.nextToken();
                emp.setRole(jsonParser.getText());
            } else if("cities".equals(name)){
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    emp.getCities().add(jsonParser.getText());
                }

            } else if("properties".equals(name)){
                jsonParser.nextToken();
                while(jsonParser.nextToken() != JsonToken.END_OBJECT){
                    String key = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    String value = jsonParser.getText();
                    emp.getProperties().put(key, value);
                }
            }
        }
    }
}
