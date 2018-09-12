package com.example.demo.singleton;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {

    public Integer sort(Integer numbers) {
        return 10;
    }
}
