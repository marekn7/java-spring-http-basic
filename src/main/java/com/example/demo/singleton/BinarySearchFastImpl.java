package com.example.demo.singleton;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Slf4j
public class BinarySearchFastImpl {

    private SortAlgorithm sortAlgorithm;

    @Autowired
    @Qualifier("bubble")
    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public Integer binarySearch(Integer number) {

        int number1 = sortAlgorithm.sort(number);
        System.out.println(number1);

        return 3;
    }
}
