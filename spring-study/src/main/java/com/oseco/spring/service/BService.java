package com.oseco.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BService {
    @Autowired
    private AService aService;

    public void test() {
        System.out.println("BService.test");
    }
}
