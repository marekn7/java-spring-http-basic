package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {

        String title = "<h3>Basic HTTP</h3>";
        String login_page = "<a href='http://localhost:8080/login'>Link - Login page</a>";
        String calculator = "<a href='http://localhost:8080/calculator'>Link - Calculator page</a>";
        String logger = "<a href='http://localhost:8080/logger'>Link - Logger page</a>";
        String json = "<a href='http://localhost:8080/json'>Link - JSON page</a>";
        String singleton = "<a href='http://localhost:8080/singleton'>Link - Singleton page</a>";

        return title+login_page+ "</br>" +calculator+ "</br>" +logger+ "</br>" +json+ "</br>" +singleton;
    }
}
