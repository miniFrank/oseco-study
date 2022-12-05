package com.oseco.basic.domain;

import lombok.Data;

@Data
public class User {
    private String username;

    private void privateTest() {
        System.out.println("privateTest");
    }

    public void publicTest() {
        System.out.println("publicTest");
    }
}
