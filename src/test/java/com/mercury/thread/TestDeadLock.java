package com.mercury.thread;

public class TestDeadLock {

    private static class Friend {
        String name;
        public Friend(String name) {
            this.name = name;
        }
        public synchronized void bow(Friend another) {
            System.out.println(name + " bows to " + another.name);
            another.bowBack(this);
        }
        public synchronized void bowBack(Friend another) {
            System.out.println(name + " bows back to " + another.name);
        }
    }
    public static void main(String[] args) throws Exception {
        Friend alice = new Friend("Alice");
        Friend bob = new Friend("Bob");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                alice.bow(bob);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                bob.bow(alice);
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("End of Main");
    }

}
