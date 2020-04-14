package com.mercury.io;

import java.io.*;

public class TestR2 {

    public static void main(String[] args) {
        try( FileInputStream fis = new FileInputStream("data1/t2.txt");
             DataInputStream dis = new DataInputStream(fis);) {
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
