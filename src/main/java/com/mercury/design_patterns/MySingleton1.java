package com.mercury.design_patterns;

// Singleton Class: can only create one instance of this class
// 70
// eager mode singleton: instance is create when class is loaded in method area
public class MySingleton1 {

    // 2. create an instance of class
    private static MySingleton1 INSTANCE = new MySingleton1();

    // 1. make constructor to be private
    private MySingleton1() {}

    // 3. provide a static getInstance method to provide instance which is created inside class
    public static MySingleton1 getInstance() {
        return INSTANCE;
    }

}
