package com.mercury.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

import static org.junit.Assert.*;

public class DrinkableTest {

    @Test
    public void test() {
        // before java 8
        Drinkable water = new Drinkable() {
            @Override
            public void drink() {
                System.out.println("drinking water...");
            }
        };
        water.drink();
        // after java 8
        // lambda function -> replace anonymous inner class
        // which is used to implement functional interface
        // lambda function will be used to override that
        // single abstract method in functional interface
        // java will convert lambda function to a class
        // and create an instance of class automatically
        // coke is an Drinkable object!!!!!!!

        // write less, clean and neat readable codes
        Drinkable coke = () -> { // drink method
            System.out.println("drinking code");
        };

        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

        // other built-in functional interface
        // supplier: take no params, return 1 value.
        Supplier<Integer> supplierRandom = () -> (int)(Math.random() * 10);
        System.out.println(supplierRandom.get());

        // consumer: take 1 param, return nothing
        Consumer<String> consumer = (name) -> {
            System.out.println(new StringBuilder(name).reverse());
        };
        consumer.accept("Alice");

        // BiConsumer: take 2 params, return nothing
        BiConsumer<String, String> biConsumer = (firstName, lastName) -> {
            System.out.println(lastName + firstName);
        };
        biConsumer.accept("He", "Huang");

        // Predicate: take 1 param, return boolean
        Predicate<Integer> testEven = (num) -> num % 2 == 0;
        System.out.println(testEven.test(10));

        // Function: take 1 param, return 1 value of any type
        // first generic type is input type
        // second generic type is return type
        Function<String, Integer> getLength = str -> str.length();
        System.out.println(getLength.apply("abc"));

        // BiFunction: take two params, return 1 value of any type
        // first generic type is first param type
        // second generic type is second param type
        // third generic type is return type
        BiFunction<String, String, Integer> getTotal = (str1, str2) -> str1.length() + str2.length();
        System.out.println(getTotal.apply("abc","defg"));

        // UnaryOperator: take 1 param, return 1 value of same type
        // UnaryOperator is a special function
        UnaryOperator<Integer> doubleNumber = i -> i * 2;
        System.out.println(doubleNumber.apply(10));
    }

}