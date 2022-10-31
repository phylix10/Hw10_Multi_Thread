package org.example.answer3;

public class Test2 implements Runnable{
    private final StringBuffer stringBuffer;

    public Test2(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    @Override
    public void run() {
        System.out.println("in run method " + Thread.currentThread().getName());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stringBuffer.append(Thread.currentThread().getName());
        System.out.println("String " + stringBuffer);
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abc");

        Thread t1 = new Thread(new Test2(str));
        Thread t2 = new Thread(new Test2(str));
        Thread t3 = new Thread(new Test2(str));

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
        System.out.println("String is " + str);
    }
}
