package org.example.answer3;

public class Test1 implements Runnable {
    private String s;

    public Test1(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        System.out.println("in run method " + Thread.currentThread().getName());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        s = s + Thread.currentThread().getName();
        System.out.println("String " + s);
    }

    public static void main(String[] args) {
        String str = "abc";

        Thread t1 = new Thread(new Test1(str));
        Thread t2 = new Thread(new Test1(str));
        Thread t3 = new Thread(new Test1(str));
        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("String is " + str.toString());
    }
}
