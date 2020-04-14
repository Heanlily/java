package com.mercury.thread;

import java.util.Collections;
import java.util.concurrent.*;

import static org.junit.Assert.*;

public class FactorialTaskTest {


    public static void main(String[] args) {
        // Thread Pool
        // a pool of threads to reuse and avoid overheads of creating/destroying thread
        // new Thread() * 1000 -> create 1000 thread
        // each thread runs 1s, create thread takes 0.1s
        // total: (1 + 0.1) * 1000 = 1100s

        // if use a thread pool of size as 10
        // only 10 threads will be created and reused.
        // total: 1 * 1000 + 0.1 * 10 = 1001s

        // Cached Thread Pool
        // Fixed Thread Pool
        // Single Thread Executor
        // Scheduled Thread Pool
        // size of thread pool is normally set to the number of threads you CPU can run in parallel.
        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            Runnable r1 = () -> {
                System.out.println(Thread.currentThread().getName() + " executes r1.");
            };
//            new Thread(r1).start(); // create 10 threads
            pool1.execute(r1); // thread pool will create a new thread or reuse existing thread to execute r1
        }
        pool1.shutdown(); // destroy threads in the thread pool

        // We can only use thread pool to create threads for executing
        // Callable tasks.
        FactorialTask factorialTask = new FactorialTask(10);
        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        try {
            // Result of callable task will be returned in the future.
            Future<Long> future = pool2.submit(factorialTask);
            // block current thread until callable task will return value in the future.
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool2.shutdown();
        }
        System.out.println("end of main");
    }

}