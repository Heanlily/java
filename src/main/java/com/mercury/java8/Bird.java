package com.mercury.java8;

public class Bird implements Flyable, Eatable {

    @Override
    public void test() {
        System.out.println("override test in Bird");
    }

    @Override
    public void test1() {
        System.out.println("test1 in Bird");
    }

    // abstract method must be overridden in child class
    // default method is optional to be overridden
    // static method can't be overridden

}
