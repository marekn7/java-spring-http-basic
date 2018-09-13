package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Controller
public class CookieController {

    @RequestMapping("/cookie")
    @ResponseBody
    public String cookieIndex(HttpServletResponse request) {

        Cookie cookie = new Cookie("rohlik", "cz");
        request.addCookie(cookie);

        return "Cookie";
    }
}
