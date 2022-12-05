package com.oseco.spring.config;

public interface ITest {
    default void test() {
        System.out.println("test");
    }
}
