package com.mercury.design_patterns;

// 80
// lazy singleton
public class MySingleton2 {

    private static MySingleton2 INSTANCE;

    private MySingleton2(){}

    public static MySingleton2 getInstance() {
        if (INSTANCE == null) { // t1, t2
            INSTANCE = new MySingleton2();
        }
        return INSTANCE;
    }

}
