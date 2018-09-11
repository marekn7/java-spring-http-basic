package com.example.demo.services;

import com.example.demo.services.LoginService;
import org.springframework.stereotype.Component;

@Component
public class ValidPassword implements LoginService {

    public Boolean validPassword(String pass) {
        if (pass.equals("heslo")) {
            return true;
        } else {
            return false;
        }
    }
}
