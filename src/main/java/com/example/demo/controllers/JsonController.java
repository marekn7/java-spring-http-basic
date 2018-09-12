package com.example.demo.controllers;

import com.example.demo.services.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class JsonController {

    private JsonService jsonServiceEmployee;
    private JsonService jsonServiceEmployeeTest;

    @Autowired
    @Qualifier("employee")
    public void setJsonServiceEmployee(JsonService jsonServiceEmployee) {
        this.jsonServiceEmployee = jsonServiceEmployee;
    }

    @Autowired
    @Qualifier("employeeTest")
    public void setJsonServiceEmployeeTest(JsonService jsonServiceEmployeeTest) {
        this.jsonServiceEmployeeTest = jsonServiceEmployeeTest;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public String jsonIndex() {

        String title = "<h2>JSON page</h2>";
        String data1 = "<a href='http://localhost:8080/json/data1'>link - data1</a>";
        String show_data1 = "<a href='http://localhost:8080/json/show_data1'>Show data1</a>";
        String data2 = "<a href='http://localhost:8080/json/data2'>link - data2</a>";
        String show_data2 = "<a href='http://localhost:8080/json/show_data2'>Show data2</a>";

        return title + data1 + "</br>" + show_data1 + "</br>" + data2 + "</br>" + show_data2;
    }

    @RequestMapping(value = "/json/data1", method = RequestMethod.GET)
    public String jsonData1() {

        return "data.txt";
    }

    @RequestMapping(value = "/json/data2", method = RequestMethod.GET)
    public String jsonData2() {

        return "employee.txt";
    }

    @RequestMapping(value = "/json/show_data1", method = RequestMethod.GET)
    @ResponseBody
    public String readJson1() throws IOException {

        String title = "<h3>Show data</h3>";

        String data = jsonServiceEmployeeTest.readJson("http://localhost:8080/json/data1");

        return title + data;
    }

    @RequestMapping(value = "/json/show_data2", method = RequestMethod.GET)
    @ResponseBody
    public String readJson2() throws IOException {

        String data = jsonServiceEmployee.readJson("http://localhost:8080/json/data2");

        return data;
    }
}