package com.mercury.design_patterns;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

// 95
// thread-safe singleton
// double-checking singleton
public class MySingleton3 {

    private static MySingleton3 INSTANCE;

    private MySingleton3() {}

    // synchronized getInstance method: only allow one thread to get
    // the instance at one time.(very bad performance)
    public static MySingleton3 getInstance() {
        // if one thread t1 already created the instance,
        // other threads should just return the instance.
        if (INSTANCE == null) {
            synchronized (MySingleton3.class) { // t2
                if (INSTANCE == null) {
                    INSTANCE = new MySingleton3();
                }
            }
        }
        return INSTANCE;
    }

}
