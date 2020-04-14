package com.mercury.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestR3 {

    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("data1/t3.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);) {
            // Data class now is different from the class when object was written.
            // when data was written, serialVersionUID = -3187664550887281760
            // now, serialVersionUID = 555469227964221493
            Data data = (Data)ois.readObject();
            System.out.println(data);
            System.out.println(data.s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
