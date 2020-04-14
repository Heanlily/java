package com.mercury.java8;

// functional interface: has only one abstract method.
@FunctionalInterface
public interface Drinkable {

    void drink();

    // methods coming from Object class
    // Drinkable coke = () -> {};
    // lambda function will not be used to override any methods
    // from Object class. because java can always get access to
    // those methods from Object class since any object in java
    // inherits Object class.
    // coke.equals();
    boolean equals(Object object);
    int hashCode();
    String toString();

    default void test1() {

    }

    static void test2() {

    }

}
