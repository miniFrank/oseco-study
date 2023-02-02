package com.oseco.basic.juc;

public class ThreadBasicTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "---with i---" + i);
                    Thread.yield();
                }
            }
        };
        new Thread(runnable, "test1").start();
        new Thread(runnable, "test2").start();
    }
}
