package leetcode.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

class FooBar {
    private int n;
    private Map<Integer, CountDownLatch> map;

    public FooBar(int n) {
        this.n = n;
        this.map = new HashMap<>(n);
        this.map.put(0, new CountDownLatch(1));
        this.map.put(1, new CountDownLatch(1));
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            this.map.get(i).countDown();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            this.map.get(i).await();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
    }
}
