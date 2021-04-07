package juc;

import java.util.concurrent.SynchronousQueue;

public class CollectionStudy {
    public final static SynchronousQueue synchronousQueue = new SynchronousQueue();
    public static final void testSynchronousQueueProducer() throws InterruptedException {
        while(true) {
            synchronousQueue.put("hello");
        }
    }

    public static final void testSynchronousQueueConsumer() throws InterruptedException {
        while(true) {
            System.out.println(synchronousQueue.take());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        testSynchronousQueueProducer();
        testSynchronousQueueConsumer();
    }
}
