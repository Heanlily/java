package com.mercury.java8;

public interface Flyable {

    // all the class member variables are public static final.
    // public static final int x = 1;
    // int y = 1;

    // before java 8, interface can only have public abstract method.
    public void test();

    boolean equals(Object object);

    // since java 8, it introduces concrete default and static methods.
    public default void test1() {
        System.out.println("test1 in Flyable");
    }

    public static void test2() {
        System.out.println("static test2 in Flyable");
    }
}
