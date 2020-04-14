package com.mercury.thread;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
                Integer data = blockingQueue.take();
                System.out.println("Consumer " + Thread.currentThread().getName() + ": " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
