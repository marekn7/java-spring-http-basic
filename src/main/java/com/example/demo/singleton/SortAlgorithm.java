package com.example.demo.singleton;

import org.springframework.stereotype.Component;

@Component
public interface SortAlgorithm {

    public Integer sort(Integer number);
}