package com.example.demo.controllers;

import com.example.demo.services.JsonEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class JsonController {

    private JsonEmployeeService jsonEmployeeService;

    @Autowired
    public void setJsonEmployeeService(JsonEmployeeService jsonEmployeeService) {
        this.jsonEmployeeService = jsonEmployeeService;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public String jsonIndex() {

        String title = "<h2>JSON page</h2>";
        String data1 = "<a href='http://localhost:8080/json/data1'>link - data1</a>";
        String show_data1 = "<a href='http://localhost:8080/json/show_data1'>Show data1</a>";
        String data2 = "<a href='http://localhost:8080/json/data2'>link - data2</a>";

        return title + data1 + "</br>" + show_data1 + "</br>" + data2;
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
    public String writeJson() throws IOException {

        String title = "<h3>Show data</h3>";

        String data = jsonEmployeeService.readData("http://localhost:8080/json/data1");

        return title + data;
    }


}
