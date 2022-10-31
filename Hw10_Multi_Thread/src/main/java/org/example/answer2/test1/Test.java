package org.example.answer2.test1;

public class Test {
    synchronized void task1(Test s2) {
        System.out.println("test1-begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        s2.task2();
        System.out.println("test1-end");
    }

    synchronized void task2() {
        System.out.println("test2-begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("test2-end");
    }
}
