package com.example.demo.controllers;

import com.example.demo.singleton.BinarySearchFastImpl;
import com.example.demo.singleton.BinarySearchSlowImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SingletonController {

    private BinarySearchSlowImpl binarySearchSlow1;
    private BinarySearchSlowImpl binarySearchSlow2;

    private BinarySearchFastImpl binarySearchFast1;
    private BinarySearchFastImpl binarySearchFast2;

    @Autowired
    public void setBinarySearchSlow1(BinarySearchSlowImpl binarySearchSlow1) {
        this.binarySearchSlow1 = binarySearchSlow1;
    }

    @Autowired
    public void setBinarySearchSlow2(BinarySearchSlowImpl binarySearchSlow2) {
        this.binarySearchSlow2 = binarySearchSlow2;
    }

    @Autowired
    public void setBinarySearchFast1(BinarySearchFastImpl binarySearchFast1) {
        this.binarySearchFast1 = binarySearchFast1;
    }

    @Autowired
    public void setBinarySearchFast2(BinarySearchFastImpl binarySearchFast2) {
        this.binarySearchFast2 = binarySearchFast2;
    }

    @RequestMapping(value = "/singleton", method = RequestMethod.GET)
    @ResponseBody
    public String singletonIndex() {

        String singleton = "<h4>Singleton</h4>";

        String prototype1 = binarySearchSlow1.toString();
        String prototype2 = binarySearchSlow2.toString();

        String prototype = "<h4>Prototype</h4>";

        String singleton1 = binarySearchFast1.toString();
        String singleton2 = binarySearchFast2.toString();

        return singleton + singleton1 + " </br> " + singleton2 + prototype + prototype1 + " </br> " + prototype2;
    }
}
