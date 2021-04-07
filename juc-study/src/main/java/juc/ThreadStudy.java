package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程的合并的含义就是 将几个并行线程的线程合并为一个单线程执行，
 * 应用场景是 当一个线程必须等待另一个线程执行完毕才能执行时，Thread类提供了join方法来完成这个功能，注意，它不是静态方法。
 * <p>
 * 1. 如果在主线中调用了join，主线程会等待现成执行完之后，才会退出
 * <p>
 * 参考：
 * https://juejin.im/post/5b3054c66fb9a00e4d53ef75
 * https://segmentfault.com/a/1190000015558984
 */
public class ThreadStudy {
    public static final int N_CPU = Runtime.getRuntime().availableProcessors();

    static final void testThread() {
        System.out.println("main thread start!");
        Thread thread2 = new Thread(new CDThread());
        Thread thread1 = new Thread(new JJSThread(thread2));
        thread1.start();
//        Thread.sleep(1000L);
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread end!");
        System.exit(0);
    }

    static final void testThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(N_CPU, new CustomizedThreadFactory());
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        testThread();
        testThreadPool();
    }
}

class CustomizedThreadFactory implements ThreadFactory {

    private final ThreadGroup group;
    private final AtomicInteger index = new AtomicInteger(1);

    CustomizedThreadFactory() {
        SecurityManager sm = System.getSecurityManager();
        group = (sm != null) ? sm.getThreadGroup()
                : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, "oseco-test-"
                + index.getAndIncrement());
        t.setDaemon(true);
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}

class JJSThread implements Runnable {
    private Thread joinThread;

    public JJSThread(Thread jThread) {
        this.joinThread = jThread;
    }

    @Override
    public void run() {
//        try {
//            this.joinThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("阻击手准备");
    }
}

class CDThread implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("拆弹手准备");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println("拆弹手完毕");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
