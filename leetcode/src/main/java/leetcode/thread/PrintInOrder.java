package leetcode.thread;

public class PrintInOrder {
    public static void main(String[] args) throws InterruptedException {
//        "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
//        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"

        System.out.println(Long.toBinaryString(4));
    }
}

class Foo {
    private volatile boolean i;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputCountDownLatchs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public void print(int i) throws InterruptedException {
        System.out.println(i);
        synchronized (this) {
            if (i == 1) {
                this.first(() -> System.out.println("one"));
            } else if (i == 2) {
                this.second(() -> System.out.println("two"));
            } else if (i == 3) {
                this.third(() -> System.out.println("three"));
            }
        }
    }
}
