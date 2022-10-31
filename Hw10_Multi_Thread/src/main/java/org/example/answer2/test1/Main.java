package org.example.answer2.test1;

public class Main {
    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();

        Thread1 thread1 = new Thread1(test1, test2);
        thread1.start();

        Thread2 thread2 = new Thread2(test1, test2);
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
