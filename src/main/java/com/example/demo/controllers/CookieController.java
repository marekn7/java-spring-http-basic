package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cookie")
public class CookieController {

    @RequestMapping("")
    @ResponseBody
    public String cookieIndex(HttpServletResponse request) {

        String title = "<h1>Cookie</h1>";

        String counter = "<a href='http://localhost:8080/cookie/counter'>Link - Cookie counter</a>";

        Cookie cookie1 = new Cookie("rohlik1", "cz");
        request.addCookie(cookie1);

        Cookie cookie2 = new Cookie("rohlik2", "de");
        request.addCookie(cookie2);

        Cookie cookie3 = new Cookie("rohlik3", "hu");
        request.addCookie(cookie3);

        Cookie cookie4 = new Cookie("rohlik4", "po");
        request.addCookie(cookie4);

        return title + counter;
    }

    @RequestMapping("/counter")
    @ResponseBody
    public String cookieCounter(@CookieValue(value = "counter", defaultValue = "0") Long counter, HttpServletResponse response) {

        counter++;

        Cookie cookieCounter = new Cookie("counter", counter.toString());
        response.addCookie(cookieCounter);

        return counter.toString();
    }

}
