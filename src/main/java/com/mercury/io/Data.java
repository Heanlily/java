package com.mercury.io;

import java.io.Serializable;

// marker(flag) to let Java know you intend to allow others to write/read Data
// objects.
// marker interface: empty interface
public class Data implements Serializable {

    private static final long serialVersionUID = 1;

    private int x = 1;
    // how to prevent y's value to be written into file?
    // when write, default value will be written in file.
    private transient double y = 1.5;
    private char z = 's';
    public static int s = 100;

    public Data() {
    }

    public Data(int x, double y, char z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public char getZ() {
        return z;
    }

    public void setZ(char z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "My Data{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
