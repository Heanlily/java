package com.mercury.oop;

public class Child extends Parent{

    int a = 1;
    static int b = 2;

    public static int x1 = 300;
    public int x2 = 400;

    Child() {
        super();
        System.out.println("Child constructor is invoked.");
    }

    Child(int a) {
        this.a = a;
        System.out.println("Child constructor with args is invoked.");
    }

    // non static function can use both static and non-static variables/functions
    void test1() {
        System.out.println(a);
        System.out.println(b);
    }

    // static function can only use static variables/functions
    static void test2() {
//        System.out.println(a);
        System.out.println(b);
    }

    // overload

    // hello();
    public void hello() {

    }

    // hello(1);
    public void hello(int x) {

    }

    // hello("abc");
    public void hello(String x) {

    }

    // function name must be same
    // parameters must be of same number and type.
    // return type: same or IS-A relationship.
    // throws Exception???
    @Override
    public Integer print(int a, int b) {
        System.out.println("Difference:" + (a - b));
        return a - b;
    }

}
