package com.mercury.thread;

public class TestThreadLocal {

    static class Data {
        int x = 10;

        ThreadLocal<Integer> y = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 20;
            }
        };
    }

    public static void main(String[] args) {
        Data data = new Data();
        // i want to let each thread has it local copy of data.x
        Thread t1 = new Thread(() -> {
            data.x++;
            System.out.println(data.x + " in t1");

            // 20
            data.y.set(data.y.get() + 1);
            System.out.println(data.y.get() + " in t1");
        });
        Thread t2 = new Thread(() -> {
            data.x++;
            System.out.println(data.x + " in t2");

            // 20
            data.y.set(data.y.get() + 1);
            System.out.println(data.y.get() + " in t2");
        });
        t1.start();
        t2.start();
    }

}
