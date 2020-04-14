package com.mercury.collection;

// POJO: plain old java object
// add default comparsion rule for user which will be used
// whenever user will be compared.
public class User implements Comparable<User>{

    private String name;
    private int age;
    private float score;

    public User(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(User another) {
        // compare current user to another user
        // compare using score
        // 1.1 -> 1
        return (int)(this.score - another.score); // type conversion
    }
}
