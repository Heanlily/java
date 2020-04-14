package com.mercury.thread;

import static org.junit.Assert.*;

public class MyRunnable1Test {

    public static void main(String[] args) {
        // Runnable is not a thread!!!
        MyRunnable1 myRunnable1 = new MyRunnable1(); // task
        // create a new thread to execute the Runnable task
        Thread thread = new Thread(myRunnable1);
        thread.start();

        // use lambda function to create a runnable.
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running. (lambda)");
        };
        new Thread(runnable).start();;
    }

}