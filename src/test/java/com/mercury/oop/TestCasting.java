package com.mercury.oop;

import org.junit.Test;

public class TestCasting {

    @Test
    public void test() {
        // Child extends Parent
        // Child is-a Parent

        // Parent
        // |
        // Child

        Parent parent = new Parent();
        Child child = new Child();
        // up casting: automatically
        Parent parent1 = (Parent) child;
        Parent parent2 = child;
        // down casting
        // A a = (A) b;
        // down casting is only allowed when b's actual type is A.

        // why we don't have errors during compile time?
        // during compile time, Java only knows the reference type
        // of parent - Parent. It has no idea about the actual type.
        // Java will check whether b's reference type is a super class of A.

        // why we have runtime error???
        // during runtime, Java will know the actual type of parent is
        // Parent not Child. Then Java will not be able to do the
        // down casting.
//        Child child1 = (Child) parent;

        // reference type: Parent
        // actual type: Child
        Parent parent3 = new Child();
        Child child2 = (Child) parent3;
    }

}
