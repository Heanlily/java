package com.mercury.thread;

public class TestDaemonThread {

    public static void main(String[] args) {
        // a daemon thread will automatically terminate
        // if there is no other active thread.
        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                i++;
            }
        });
        // how to let thread terminate automatically when
        // there is no other thread(main).
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end of main");
    }

}
