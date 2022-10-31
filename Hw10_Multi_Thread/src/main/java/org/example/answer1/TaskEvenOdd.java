package org.example.answer1;

import java.util.ArrayList;
import java.util.List;

public class TaskEvenOdd {
    private final List<Integer> list = new ArrayList<>();
    private final List<Integer> evenList = new ArrayList<>();
    private final List<Integer> oddList = new ArrayList<>();

    private boolean odd = false;
    public int counter = 0;

    public List<Integer> getList() {
        return list;
    }

    public void printEven(int number) {
        synchronized (this) {
            while (counter < number) {
                while (odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                evenList.add(counter);
                list.add(counter);
                counter++;
                odd = true;
                notify();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + evenList);
    }

    public void printOdd(int number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        synchronized (this) {
            while (counter < number) {
                while (!odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                oddList.add(counter);
                list.add(counter);
                counter++;
                odd = false;
                notify();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + oddList);
    }
}
