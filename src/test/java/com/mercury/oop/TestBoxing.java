package com.mercury.oop;

import org.junit.Test;

public class TestBoxing {

    @Test
    public void test() {
        int i = 1;
        // boxing
        Integer integer = new Integer(i);
        // unboxing
        int j = integer.intValue();

        // auto-boxing
        Integer another = i; // new Integer(i)

        // auto-unboxing
        int k = another; // another.intValue()
    }

}
