package com.mercury.thread;

public class TestVolatile {

    // any thread uses num will read num from main memory
    // any thread will directly write updated num to main memory
    // ensure variable visibility among multiple threads.
    static volatile int num = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (num >= 5) {
                    break;
                }
            }
            System.out.println(num + " in t1");
        });
        // num which is incremented by t2 is not visible to t1
        Thread t2 = new Thread(() -> {
            while (num < 10) {
                num++;
                System.out.println(num + " in t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
