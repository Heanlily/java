package com.mercury.io;

import java.io.*;

public class TestW2 {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data1/t2.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos);) {
            dos.writeInt(-1);
            dos.writeDouble(1.1);
            dos.writeBoolean(false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
