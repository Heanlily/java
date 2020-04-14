package com.mercury.thread;

import static org.junit.Assert.*;

public class MyIntListTest {

    public static void main(String[] args) throws InterruptedException {
        MyIntList m1 = new MyIntList();
        MyIntList m2 = new MyIntList();
        Thread t1 = new Thread(() -> {
//           m1.add(10);
//           m1.add(20);
            MyIntList.test2();
        });
        Thread t2 = new Thread(() -> {
//            m1.add(30);
//            m1.add(40);
            MyIntList.test2();
        });
        t1.start();
        t2.start();

        // In thread A, if you can B.join().
        // Then A thread will wait for B thread to finish.

        t1.join(); // main thread will wait until t1 finishes to continue
        t2.join(); // main thread will wait until t2 finishes to continue
        // execute after t1 and t2 finishes
//        System.out.println(m1);
        System.out.println(MyIntList.ai.get());
    }

}