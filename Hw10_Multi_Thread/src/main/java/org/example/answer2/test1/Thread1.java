package org.example.answer2.test1;

import org.example.answer2.test1.Test;

public class Thread1 extends Thread {
    private final Test test1;
    private final Test test2;

    public Thread1(Test test1, Test test2) {
        this.test1 = test1;
        this.test2 = test2;
    }

    @Override
    public void run() {
        test1.task1(test2);
    }
}
