package com.mercury.thread;

import static org.junit.Assert.*;

public class MyThread1Test {

    public static void main(String[] args) {
        // for any java app, it will start at least two threads.
        // main thread
        // GC(garbage collection) thread

        // create one custom thread
        MyThread1 myThread1 = new MyThread1();
        // how to launch/start the thread to execute our task?
        myThread1.setName("myThread1");
        myThread1.start(); // start the thread and execute run()

        // invoke run method directly will not create a new thread.
        // it executes run() in main thread
//        myThread1.run(); // NOT CORRECT.
    }

}