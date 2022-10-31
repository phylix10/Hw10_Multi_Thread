package org.example.answer4;

import java.util.concurrent.atomic.AtomicInteger;

public class StarvationExample {
    private static final Object mutex = new Object();
    private static volatile boolean isActive = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(), "Thread_1_P10");
        Thread t2 = new Thread(new Worker(), "Thread_2_P8");
        Thread t3 = new Thread(new Worker(), "Thread_3_P6");
        Thread t4 = new Thread(new Worker(), "Thread_4_P4");
        Thread t5 = new Thread(new Worker(), "Thread_5_P2");

        // Priorities only serve as hints to scheduler, it is up to OS implementation to decide
        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isActive = false;

    }

    private static class Worker implements Runnable {
        private final AtomicInteger runCount = new AtomicInteger();

        public void run() {
            while (isActive) {
                synchronized (mutex) {
                    try {
                        doWork();
                    } catch (Exception e) {
                        System.out.format("%s was interrupted...\n", Thread.currentThread().getName());
                        e.printStackTrace();
                    }
                }
            }
            System.out.format("DONE===> %s: Current runCount is %d...\n", Thread.currentThread().getName(), runCount.get());
        }

        private void doWork() {
            System.out.format("%s: Current runCount is %d...\n", Thread.currentThread().getName(), runCount.getAndIncrement());
        }
    }
}
