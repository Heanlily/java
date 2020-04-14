package com.mercury.java8;

import org.junit.Test;

import static org.junit.Assert.*;

public class BirdTest {

    @Test
    public void test() {
        Bird bird = new Bird();
        bird.test();
        // use instance of the interface to access
        // default method in the interface.
        bird.test1();
        // static method in interface can only be accessed using
        // interface name
        Flyable.test2();
    }

}