package com.mercury.thread;

public class TestYield {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    Thread.yield(); // t1 gives up CPU time slice and go back to Runnable state
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                    Thread.yield(); // t2 gives up CPU time slice and go back to Runnable state
                }
            }
        });
        t1.start();
        t2.start();
    }

}
