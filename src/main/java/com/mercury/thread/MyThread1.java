package com.mercury.thread;

public class MyThread1 extends Thread{

    // execute/run a task
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.(MyThread1)");
    }


}
