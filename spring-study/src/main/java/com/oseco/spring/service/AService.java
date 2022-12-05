package com.oseco.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AService {
    @Autowired
    private BService bService;

    public void test() {
        System.out.println("AService.test");
    }
}
