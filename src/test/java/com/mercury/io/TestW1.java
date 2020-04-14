package com.mercury.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestW1 {

    public static void main(String[] args) {
        // get negative: reverse + 1
        // last 8 bit of integer will be written in file
        // -1: 11111111 11111111 11111111 11111111
        // 2: 00000000 00000000 00000000 00000010
        // 123456: 00000000 00000001 11100010 01000000
        int[] arr = {-1, 2, 3, 4, 123456};
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("data1/t1.txt");
            // enhanced for loop
            for (int num : arr) {
                fos.write(num); // 1 byte
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
