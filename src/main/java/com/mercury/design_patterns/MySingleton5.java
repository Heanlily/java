package com.mercury.design_patterns;

// 99
// holder pattern singleton
// lazy, thread-safe
public class MySingleton5 {

    private MySingleton5() {}

    // java first will load MySingleton5 class on JVM
    // during loading MySingleton5 class, only static variables/blocks in MySingleton5
    // will be initialized/executed
    // static class(Holder) will not be loaded.
    // Whatever in Holder will only be executed when Holder class is used!!!
    private static class Holder {
        // since Holder class will only be loaded by Java once,
        // static variables(INSTANCE) will only created once.
        // java will finish loading class as atomic operation which means
        // when one thread is loading the class, other threads will be blocked.
        static final MySingleton5 INSTANCE = new MySingleton5();
    }

    public static MySingleton5 getInstance() {
        // use Holder class, java loads Holder class and create the INSTANCE
        // lazy
        return Holder.INSTANCE;
    }

}
