package com.mercury.thread;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

// it works perfectly in single thread environment
// but this list can't store all elements in multi-threading environment
// the list is not thread-safe .
public class MyIntList {

    int[] table;
    int size;
    static int total = 0;
    // special Integer with atomic operations
    static AtomicInteger ai = new AtomicInteger(0);

    public MyIntList() {
        this.table = new int[1];
    }

    // who is calling add()? -> t1
    // who is holding CPU time slice? -> t2

    // [10]
    // size: 0

    // t1: finishes if(), didn't resize
    // t2:

    // root cause???
    // now we allow two thread to invoke add method concurrently

    // lock add method: only allow one thread to invoke m1's add().
    // if t1 is executing m1's add(), even t2 get CPU time slice,
    // t2 will not be able to execute m1's add(). t2 is blocked.

    // non-static synchronized method
    // lock
    // t1 first invoke add(), t1 will get the lock and lock the add method.
    // even t2 get time slice, however t1 is still holding lock until t1 finishes.
    // so t2 will be blocked. t2 will not be able to execute add.
    // once t1 finishes, t1 will release the lock.
    // t2 will be moved to runnable state and then t2 will be able to acquire
    // the lock and execute add().

    // lock: the instance which is calling add. (this)
    // two threads can't not use the same instance to access the method at the same time.
    // but they can use different instance to access the method(different locks)
    public synchronized void add(int x) {
        if (size >= table.length) { // resize
            table = Arrays.copyOf(table, table.length << 1);

        }
        System.out.println(Thread.currentThread().getName() + ": " + x);
        table[size] = x;
        size++;
    }

    @Override
    public String toString() {
        return "MyIntList{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }

    // total is a shared variable
    // total:
    // t1:
    // t2:
    // synchronized static method
    // lock: MyIntList.class
    public static void test1() {
        for (int i = 0; i < 10000; i++) {
            // not atomic operation: multiple steps
            // add total by 1(total+1)
            // assign incremented value to total

            // want to ensure no two threads execute below line at one time
            // synchronized block
            // better performance since only part of function is blocked.
            synchronized (MyIntList.class) {
                total++; // total = total + 1;
            }
        }
        // some codes which have nothing to do with total
        System.out.println("hello world");
    }

    // why non-static method uses "this" as lock?
    // why static method uses "class" as lock?
    public void clear() {
        synchronized (this) {
            table = new int[0];
        }
    }

    public static void test2() {
        for (int i = 0; i < 10000; i++) {
//            total++; // not atomic operation
            ai.getAndIncrement();
        }
    }
}
