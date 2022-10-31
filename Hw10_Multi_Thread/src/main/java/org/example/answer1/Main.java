package org.example.answer1;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter number: ");
        int number = scanner.nextInt();

        TaskEvenOdd taskEvenOdd = new TaskEvenOdd();

        /*
        //Thread thread_0 = new Thread(new Runnable() {
        //@Override
        //public void run() {
        //taskEvenOdd.printEven(number);
        //}
        //});
        */

        Thread thread_0 = new Thread(() -> taskEvenOdd.printEven(number));

        /*
        //Thread thread_1 = new Thread(new Runnable() {
        //@Override
        //public void run() {
        //taskEvenOdd.printOdd(number);
        //}
        //});
        */

        Thread thread_1 = new Thread(() -> taskEvenOdd.printOdd(number));

        thread_0.start();
        thread_1.start();

        try {
            thread_0.join();
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(taskEvenOdd.getList());
    }
}
