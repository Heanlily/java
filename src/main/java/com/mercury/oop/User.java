package com.mercury.oop;

import jdk.nashorn.internal.objects.annotations.Constructor;

// User extends Object
// telling Java we intended to allow people to clone our objects.
// marker interface: an interface which doesn't has any abstract method.
public class User implements Cloneable{

    private String name;
    private int age;
    private Computer computer;

    public User(Student student) {
        this.name = student.getName();
        this.age = student.getAge();
        this.computer = new Computer("Macbook");
    }

    public User(String name, int age, Computer computer) {
        this.name = name;
        this.age = age;
        this.computer = computer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    // why override clone?
    // allow others to clone user outside of User class.
    @Override
    public User clone() throws CloneNotSupportedException {
        // how to reference current user to be cloned? this
        // want to use Object's clone method to clone current user?
        // this.clone() -> clone in user
        // super means to find clone() in parent class.
        // use parent class clone method to clone current instance(this)
        User clonedUser = (User)super.clone();
        Computer clonedComputer = (Computer)this.getComputer().clone();
        clonedUser.setComputer(clonedComputer);
        return clonedUser; // downcasting
    }
}
