package com.mercury.design_patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySingleton1Test {

    @Test
    public void test() {
        // should not all others to use new to create an object
        // otherwise you have more than copy.
//        MySingleton1 ms1 = new MySingleton1();
//        MySingleton1 ms2 = new MySingleton1();
        MySingleton1 ms1 = MySingleton1.getInstance();
    }

}