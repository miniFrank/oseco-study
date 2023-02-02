package com.oseco.basic.juc;

import java.util.concurrent.locks.LockSupport;

public class ThreadParkTest {

    public int test() {
        try {
            boolean flag = false;
            for (; ; ) {
                if (flag) {
                    return 1;
                }

                LockSupport.park(this);
                Thread.interrupted();
                flag = true;
            }
        } finally {
            finalRun();
        }
    }

    public void wakeup(){
        LockSupport.unpark(Thread.currentThread());
    }

    private void finalRun() {
        System.out.println("final-run");
    }

    public static void main(String[] args) {
        ThreadParkTest threadParkTest = new ThreadParkTest();
        threadParkTest.wakeup();
        System.out.println(threadParkTest.test());
    }
}
