package com.mercury.java8;

public interface Eatable {

    public default void test1() {
        System.out.println("test1 in Eatable");
    }

}
