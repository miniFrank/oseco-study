package com.oseco.basic.relection;

import com.oseco.basic.domain.User;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

public class CglibRunner {
    public static void main(String[] args) {
        User _user = new User();
        Method[] _methods = _user.getClass().getDeclaredMethods();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        enhancer.setCallback(new CglibProxy());

        User user = (User) enhancer.create();
        Method[] methods = user.getClass().getDeclaredMethods();
        user.publicTest();
    }
}
