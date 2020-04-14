package com.mercury.thread;

public class MyRunnable1 implements Runnable{

    // an object to define our task.
    @Override
    public void run() {
        // output the name of the thread which is currently executing run() method.
        System.out.println(Thread.currentThread().getName() + " is running. (MyRunnable1)");
    }
}
