package com.mercury.thread;

import java.util.concurrent.Callable;

// thread created from Callable object will return data.
public class FactorialTask implements Callable<Long> {

    private int num;

    public FactorialTask(int num) {
        this.num = num;
    }

    private Long calc(int num) throws InterruptedException {
        Thread.sleep(30);
        return num == 0 ? 1 : calc(num - 1) * num;
    }

    @Override
    public Long call() throws Exception {
        return calc(num);
    }
}
