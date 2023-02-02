package com.oseco.basic;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoader {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        System.out.println("-------------------------------------------");

        URLClassLoader extClassLoader =
                (URLClassLoader) java.lang.ClassLoader.getSystemClassLoader().getParent();
        System.out.println(extClassLoader);
        urls = extClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        System.out.println("-------------------------------------------");

        URLClassLoader urlClassLoader =
                (URLClassLoader) java.lang.ClassLoader.getSystemClassLoader();
        System.out.println(urlClassLoader);
        urls = urlClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        System.out.println("-------------------------------------------");
    }
}
