package com.mercury.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestW3 {

    public static void main(String[] args) {
        // write a Data object to file
        try(FileOutputStream fos = new FileOutputStream("data1/t3.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            Data data = new Data();
//            Data.s = 200;
            data.s = 200; // s is static. it belongs to Data class.
            // changes of s will not be written into file.
            oos.writeObject(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
