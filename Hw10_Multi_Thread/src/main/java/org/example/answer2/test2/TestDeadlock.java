package org.example.answer2.test2;

public class TestDeadlock {
    public static void main(String[] args) {
        final String resource1 = "hello";
        final String resource2 = "world";

        /*Thread t1 = new Thread() {
        //  public void run() {
        //      synchronized (resource1) {
        //          System.out.println("Thread 1: locked resource 1");
        //              try {
        //                 Thread.sleep(100);
        //              }
        //              catch (Exception e) {
        //                  e.printStackTrace();
        //              }
        //       synchronized (resource2) {
        //           System.out.println("Thread 1: locked resource 2");
        //       }
        //     }
        //   }
        //};
        */

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");
                try {
                    Thread.sleep(100);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                try {
                    Thread.sleep(100);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        /*Thread t2 = new Thread() {
        //  public void run() {
        //      synchronized (resource2) {
        //          System.out.println("Thread 2: locked resource 2");
        //              try {
        //                 Thread.sleep(100);
        //              }
        //              catch (Exception e) {
        //                  e.printStackTrace();
        //              }
        //       synchronized (resource1) {
        //           System.out.println("Thread 2: locked resource 1");
        //       }
        //     }
        //   }
        //};
        */


        t1.start();
        t2.start();
    }
}
