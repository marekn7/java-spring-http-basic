package com.example.demo.controllers;

import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    public String index() {

        return "login";
    }

    @RequestMapping(value = "/action1", method = RequestMethod.GET)
    @ResponseBody
    public String actionGet(@RequestParam("nick") String nick, @RequestParam("password") String password) {
        return nick + " " + password;
    }

    @RequestMapping(value = "/action2", method = RequestMethod.POST)
    @ResponseBody
    public String actionPost(@RequestParam("nick") String nick, @RequestParam("password") String password) {
        if (this.loginService.validPassword(password)) {
            return nick + " password OK";
        } else {
            return nick + " " + password;
        }
    }
}
