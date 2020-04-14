package com.mercury.oop;

public class Computer implements Cloneable{

    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Computer clone() throws CloneNotSupportedException{
        return (Computer) super.clone();
    }
}
