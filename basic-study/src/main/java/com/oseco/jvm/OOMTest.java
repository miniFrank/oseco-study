package com.oseco.jvm;

import com.oseco.basic.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panguanghua
 */
public class OOMTest {
    public static void main(String[] args) throws InterruptedException {
        List<User> userList = new ArrayList<>();
        while (true) {
            userList.add(new User());
            Thread.sleep(1000);
        }
    }
}
