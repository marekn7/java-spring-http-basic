package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CalculatorService {

    public Integer choose(String type, Integer num1, Integer num2) {
        if (type.equals("plus")) {
            return plusOperation(num1, num2);
        } else {
            log.info("Wrong option for calculate");
            return 0;
        }
    }

    public Integer plusOperation(Integer num1, Integer num2) {
        return num1+num2;
    }
}
