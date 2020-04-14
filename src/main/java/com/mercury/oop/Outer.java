package com.mercury.oop;

public class Outer {

    int x = 1;
    static int y = 2;

    class NonStaticInner {
        int a = 1;
        // non-static inner class can't declare any static variable/function
//        static int b = 2;
        void hello() {
            System.out.println(x);
            System.out.println(y);
        }
    }

    static class StaticInner {
        int a = 1;
        static int b = 2;
        void hello() {
            // static inner class can't use non-static variable from outer class
//            System.out.println(x);
            System.out.println(y);
        }
    }

    // new Outer().t1();
    public void t1() {
        NonStaticInner nonStaticInner = new NonStaticInner();
        StaticInner staticInner = new StaticInner();
    }

    // Outer.t2();
    public static void t2() {
        // in outer class's static function, you can't use non-static inner class.
//        NonStaticInner nonStaticInner = new NonStaticInner();
        StaticInner staticInner = new StaticInner();
    }

}
