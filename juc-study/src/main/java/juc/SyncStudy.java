package juc;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncStudy {
    private final Object lock = new Object();

//    private final SyncStudy syncStudy = new SyncStudy();

    private int i = 0;

    private long l = 0L;

    private AtomicInteger counter = new AtomicInteger();

    /**
     * -XX:+UseCompressedClassPointers 启用类指针(类元数据的指针)压缩。
     * -XX:+UseCompressedOops 启用普通对象指针压缩。
     * -XX:+PrintCommandLineFlags 打印参数
     */
    public synchronized void print() {
        System.out.println(ClassLayout.parseClass(SyncStudy.class).toPrintable());
        String layout = ClassLayout.parseInstance(lock).toPrintable();
        System.out.println(layout);
        Object[] atomicIntegers = new Object[5];
        String layouts = ClassLayout.parseInstance(atomicIntegers).toPrintable();
        System.out.println(layouts);

    }

    /**
     * 观察synchronized在字节码层面的表现
     */
    public void hello() {
        String threadId = Thread.currentThread().getName() + "-" + Thread.currentThread().getId();
        if (i > 0) {
            System.out.println(String.format("%s overload", threadId));
        } else {
            System.out.println(String.format("%s first", threadId));
        }
        synchronized (lock) {
            i += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncStudy syncStudy = new SyncStudy();
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);
//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(() -> {
//                syncStudy.hello();
//            });
//        }
//        scheduledExecutorService.shutdown();

//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//              syncStudy.hello();
//                countDownLatch.countDown();
//            }).start();
//        }
//        countDownLatch.await();

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                syncStudy.hello();
//                try {
//                    cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }

        syncStudy.print();
    }
}
