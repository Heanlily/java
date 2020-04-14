package com.mercury.oop;

// abstract class (vs Concrete class)
// can't instantiate class(can't create an object using new)
public abstract class Car {

    // can abstract has constructor?
    // we can't use new to invoked constructor
    // abstract class's constructor is normally invoked by child class(super)
    public Car () {

    }

    // has no method body!!!
    public abstract void run();

    // can have regular(concrete) method
    public void drive() {
        System.out.println("driving...");
    }

}
