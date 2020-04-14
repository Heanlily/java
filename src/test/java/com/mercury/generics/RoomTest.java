package com.mercury.generics;

import org.junit.Test;
import sun.security.krb5.internal.crypto.Des;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void test() {
        Room room1 = new Room();
        Chair chair1 = new Chair();
        Desk desk1 = new Desk();
        room1.something = chair1;
        room1.something = desk1;

        // before java 1.7,
        // type for generics must be specified on both sides

        // how to create a room which can contain Chair only?
        Room<Chair> roomWithChairOnly = new Room<>();
        roomWithChairOnly.something = chair1;
        // how to create a room which can contain Desk only?
        Room<Desk> roomWithDeskOnly = new Room<>();
        roomWithDeskOnly.something = desk1;

        // wildcard generics

        // create a print method which can print something in a room?
        print(roomWithChairOnly);
        print(roomWithDeskOnly);

        // create a print method which can print a room that is having
        // chair or gaming.
        print1(roomWithChairOnly);
        Room<GamingChair> roomWithGamingChair = new Room<>();
        print1(roomWithGamingChair);
//        print1(roomWithDeskOnly); //NOT allowed

        // create a print method which can print Room with
        // Chair/Furniture/Object
        print2(roomWithChairOnly);
        Room<Furniture> roomWithFurniture = new Room<>();
        print2(roomWithFurniture);
        Room<Object> roomWithObject = new Room<>();
        print2(roomWithObject);

//        print2(roomWithDeskOnly); // now allowed
//        print2(roomWithGamingChair); // now allowed
    }

    // lower bounded wildcard
    public void print2(Room<? super Chair> room) {
        System.out.println(room.something);
    }

    // something is-a Chair
    // upper bounded wildcard
    public void print1(Room<? extends Chair> room) {
        System.out.println(room.something);
    }

    // Room<Desk>
    // Room<Chair>
    // ?: unbounded wildcard
    public void print(Room<?> room) {
        System.out.println(room.something);
    }

}