package com.mercury.design_patterns;

// 95
// fixed set of values/objects
// enum objects are created by Java automatically when the
// enum class is loaded on JVM
// eager, thread-safe
// java create the object and it will ensure only one instance will be created
public enum MySingleton4 {
    // you can't create enum object outside the eum class
    // specify name of the enum instance in enum class separated by comma(end by ;)
    // java will automatically create the instance(s) for you.
    INSTANCE; // static. MySingleton4.INSTANCE

    private int x = 1;
    static int y = 2;

    // constructor of enum are private by default and can only be private.
    private MySingleton4() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
