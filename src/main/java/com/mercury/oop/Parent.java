package com.mercury.oop;

public class Parent {


    protected int x = 1;
    // public: everywhere
    // private: within this class
    // default(no access modifier): package level. any class within com.mercury.oop
    // protected: in any class within same package or child class in any package

    public static int x1 = 100;
    public int x2 = 200;

    // non-argument constructor
    public Parent() {
        System.out.println("Parent constructor is invoked!");
    }

    // overload
    // constructor with arguments
    Parent(int x) {
        this.x = x;
        System.out.println("Parent constructor with args is invoked");
    }

    public Number print(int a, int b) {
        System.out.println("sum: " + (a + b));
        return a + b;
    }

}
