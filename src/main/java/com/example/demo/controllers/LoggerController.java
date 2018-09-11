package com.example.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class LoggerController {

    @RequestMapping(value = "/logger", method = RequestMethod.GET)
    @ResponseBody
    public String logger() {

        String title = "<h1>Logger</h1>";

        log.info("Visit logger page");

        return title;
    }
}
