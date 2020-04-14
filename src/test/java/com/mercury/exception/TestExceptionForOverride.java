package com.mercury.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestExceptionForOverride {

    class Base {
        public void test() throws IOException {

        }
    }

    class Sub extends Base{
        @Override
        public void test() throws FileNotFoundException {

        }
    }

    // if parent method doesn't throw exception, child overridden method
    // can throws no or any unchecked exception.
    // if parent method throws unchecked exception, child overridden method
    // can throws no or any unchecked exception
    // if parent method throws checked exception, child overridden method
    // can throws no, any unchecked exception
    // or same/subclassed checked exception as/of parent method's checked exception

    // Parent: E(checked)
    // Child: E(checked), subclass of E(checked)

}
