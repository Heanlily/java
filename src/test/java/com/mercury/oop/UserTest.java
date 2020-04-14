package com.mercury.oop;

import org.junit.Test;

// import all the static methods from Assert class
// directly use those static methods in current class
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        Computer computer = new Computer("macbook");
        User user = new User("Bob", 21, computer);
        // user1 should be a new object which also has bob/21
        // user1 is a copy of user
//        User user1 = new User("Bob", 21);
        // clone user will be faster
        User user1 = user.clone();
        assertNotSame(user, user1); // user != user1
        assertEquals(user.getName(), user1.getName());
        assertEquals(user.getAge(), user1.getAge());
        assertNotSame(user.getComputer(), user1.getComputer()); // ==
//        assertEquals(user.getComputer().getName(), user1.getComputer().getName());
    }

}