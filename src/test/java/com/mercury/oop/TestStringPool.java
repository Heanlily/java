package com.mercury.oop;

import org.junit.Test;

public class TestStringPool {

    @Test
    public void test() {
        // string is object
        // string literal: "abc"
        // string object: new String("abc")
        String s1 = "abc"; // new String("abc")
        String s2 = "abc";
        System.out.println(s1 == s2); // true??
        String s3 = new String("abc"); // 1 or 2
        System.out.println(s1 == s3); // false
        String s4 = new String("abc");
        System.out.println(s3 == s4); // false

        // intern(): search for the string object
        // in the string pool which is having same contents
        System.out.println(s3.intern() == s1);

        // how many string objects are created?
        String a1 = "abc";
        String a2 = "abc" + "def";
        String a3 = "abcdef";
        String a4 = "abcde" + "f";
        String a5 = a3.toString();
        String a6 = a3.substring(0);
        String a7 = a3.concat("");
        String a8 = a3.trim();

        // String class is immutable

        // StringBuilder/StringBuffer(slow, thread-safe)
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        sb.append('b');
        sb.replace(0, 1, "c");
        System.out.println(sb.toString());

        // how to reverse string in java??
    }

}
