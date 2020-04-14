package com.mercury.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(1);

        Producer producer = new Producer(blockingQueue);

        Consumer consumer1 = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer1).start();
    }

}
