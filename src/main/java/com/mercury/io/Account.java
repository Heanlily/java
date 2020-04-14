package com.mercury.io;

import java.io.*;

// 2nd: implements Externalizable and override two methods
public class Account implements Externalizable {

    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(username);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        username = (String) in.readObject();
    }

    // 1st way: implement writeObject/readObject
    // when io read/write the object, io will automatically
    // invoke writeObject/readObject.
    // flexible
//    private void writeObject(ObjectOutputStream oos) throws IOException {
//        oos.writeObject(username);
//        oos.writeObject(password);
//    }
//
//    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        username = (String) ois.readObject();
//        // do not read the password.
//    }
}
