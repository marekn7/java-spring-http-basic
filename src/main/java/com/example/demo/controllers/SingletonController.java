package com.example.demo.controllers;

import com.example.demo.singleton.BinarySearchImpl;
import com.example.demo.singleton.BubbleSortAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SingletonController {

    @RequestMapping(value = "/singleton", method = RequestMethod.GET)
    @ResponseBody
    public String singletonIndex() {

        String title = "<h3>Singleton</h3>";

        return title;
    }
}
