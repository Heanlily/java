package com.mercury.thread;

public class TestLifeCycle {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("t1: " + i);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("t2: " + i);
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println("end of main");
    }

}
