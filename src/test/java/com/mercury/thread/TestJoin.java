package com.mercury.thread;

public class TestJoin {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
        });
        t.start();

        // let main thread wait for t thread to finish and then continue
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // how to make "end of main" printed after "hello"?
        System.out.println("end of main");
    }

}
