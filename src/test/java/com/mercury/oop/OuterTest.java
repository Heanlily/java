package com.mercury.oop;

import org.junit.Test;

import static org.junit.Assert.*;

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird flies at 10km/h!");
    }
}

public class OuterTest {

    @Test
    public void test() {
        // how to create an object of static inner class?
        Outer.StaticInner staticInner = new Outer.StaticInner();
        // how to create an object of non-static inner class?
        // non-static belongs to instance
//        Outer outer = new Outer();
        Outer.NonStaticInner nonStaticInner = new Outer().new NonStaticInner();

        final int x = 1;

        // before(include) java 1.7, local inner class and anonymous inner class
        // can only use outside function's final variables.
        // after java 1.7, they can use effectively final variables.
        // effectively final variables: variables are not actually
        // changed during current function execution.

        int y = 2;

        // local inner class
        class LocalInner {

            void print() {
                System.out.println(x);
                System.out.println(y);
            }

        }
        LocalInner localInner = new LocalInner();

//        y = 3;


        // if you want to create an object which inherits an interface/class
        // and it is used only once, then consider anonymous inner class.
        // the class will be created once and then destroyed, it will help
        // save the memory.
        // new ConcreteClass()
        Flyable plane = new Flyable() { // anonymous inner class
            @Override
            public void fly() {
                System.out.println("plane flies at 900km/h!");
            }
        };
        plane.fly();

        Parent child = new Parent() { // anonymous inner class extends parent
            @Override
            public Number print(int a, int b) {
                return a * b;
            }
        };
        child.print(1, 2);
        System.out.println(child.getClass()); // get class which creates child

        Parent parent = new Parent();
        System.out.println(parent.getClass());
    }

}