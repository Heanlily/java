package com.mercury.another;

import com.mercury.oop.Parent;
import org.junit.Test;

class SubclassOfTestAccessModifiers extends TestAccessModifiers {

}

public class TestAccessModifiers extends Parent{

    // In child class, how to access parent class's protected variable?
    // You must use current child class's instance or current child class's
    // subclass's instance to access the protected variable

    @Test
    public void test() {
        Parent p = new Parent();
//        System.out.println(p.x);

        TestAccessModifiers testAccessModifiers = new TestAccessModifiers();
        System.out.println(testAccessModifiers.x);

        SubclassOfTestAccessModifiers subclassOfTestAccessModifiers = new SubclassOfTestAccessModifiers();
        System.out.println(subclassOfTestAccessModifiers.x);
    }

}
