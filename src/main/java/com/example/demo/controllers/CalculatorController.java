package com.example.demo.controllers;

import com.example.demo.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    @ResponseBody
    public String calculatorPage() {

        String title = "<h1>Calculator</h1>";
        String calculate_plus = "<a href='http://localhost:8080/type/plus/num1/10/num2/10'>Try plus</a>";
        String calculate_minus = "<a href='http://localhost:8080/type/minus/num1/10/num2/10'>Try minus</a>";

        return title+calculate_plus+"</br>"+calculate_minus;
    }

    @RequestMapping(value = "/type/{type}/num1/{num1}/num2/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public Integer calculator(@PathVariable String type, @PathVariable Integer num1, @PathVariable Integer num2) {
        return calculatorService.choose(type, num1, num2);
    }
}
