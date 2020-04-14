package com.mercury.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void test() {
        Student student = new Student("Bob", 21);
//        student.name = "bob"; // not immutable
        System.out.println(student.getName());
        // anything inside student object can't be changed
        // student is an immutable object
    }

}