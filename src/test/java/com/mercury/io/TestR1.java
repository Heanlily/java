package com.mercury.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

public class TestR1 {

    public static void main(String[] args) {
        // want the FileInputStream to be automatically closed in finally
        // in java 1.7, try-with-resource
        // resource: any object which implements AutoCloseable interface
        // try(resource) {}
        // java will automatically generate a finally block to
        // close the resource.
        // why? ensure resource can be closed
        FileInputStream ref = null;
        try (FileInputStream fis = new FileInputStream("data1/t1.txt");) {
            ref = fis;
            int data = fis.read(); // read 1 byte from file
            // 1 byte: 1111 1111 (0 - 255)
            // int: 00000000 00000000 00000000 1111 1111
            while (data != -1) { // -1 is flag for end of file
                System.out.println(data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ref.closed
        // reflection to get private closed field
        try {
            Field closedField = FileInputStream.class.getDeclaredField("closed");
            closedField.setAccessible(true);
            System.out.println(closedField.get(ref));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
