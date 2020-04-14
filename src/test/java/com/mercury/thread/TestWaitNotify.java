package com.mercury.thread;

public class TestWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        // how to let t1 and t2 print alternatively?
        // t1 print 1, t1 waits, notify t2
        // t2 print 2, t2 waits, notify t1
        // t1 print 3, t1 waits, notify t2
        // t2 print 4, t2 waits, notify t1

        // we may have t3, t4, t5...
        // how to make sure t1 notify t2 but not other thread?

        Object lock = new Object(); // shared by t1/t2

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    // wait() must be used in synchronized method/block
                    synchronized (lock) {
                        try {
                            lock.notify(); // notify one thread which is associate with the lock to wait up.
                            lock.wait(1000); // let t1 goes to waiting status
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i < 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    synchronized (lock) {
                        try {
                            lock.notify(); // notify one thread which is associate with the lock to wait up.
                            // thread will be waiting for at most 1s
                            lock.wait(1000);    // let t1 goes to waiting status
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();

        // ReentrantLock
    }

}
