package com.mercury.oop;

import org.junit.Assert;
import org.junit.Test;

// unit test class: executed by testing library(don't need main)
// result: pass/fail
// contains methods with @Test
public class ChildTest {

    @Test
    public void test() {
        // assertions: verify if methods/variables are working as expected
//        Assert.assertEquals(1 + 1, 3);
        Child c = new Child(10);
        Assert.assertTrue(c instanceof Parent);

        Parent p = new Parent();
        System.out.println(p.x);
    }

    @Test
    public void testOverride() {
        Parent p = new Parent();
        p.print(1, 2); // Parent's print()
        Child c = new Child();
        c.print(1, 2); // Child's print()

        // very important!!!
        // coding against interface/superclass
        // declaration type(reference type): Parent
        // actual type(runtime type): Child
        // actual type must be is-a declaration type.
        Parent s = new Child();
        // during compile time, java only knows s is a Parent.
        // when Java run the codes(runtime), java will be able to
        // know s is actually a Child

        // actual type of your variable can be changed during runtime.
        s.print(1, 2); // Child's print()

        // override only applies to methods.
        // when you access any properties(static/non-static) of an object,
        // java will use its declaration type to decide the class member variable.

        // x1
        System.out.println(Parent.x1); // 100
        System.out.println(Child.x1); // 300
        System.out.println(s.x1); // not recommended. 100

        System.out.println(s.x2); // x2 in parent
    }

}
