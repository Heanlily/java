package com.mercury.exception;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("price must be positive.");
        }
        this.name = name;
        this.price = price;
    }
}

// checked
class BookIdMustPositiveException extends Exception{
    public BookIdMustPositiveException(String message) {
        super(message);
    }
}

// custom unchecked exception class
class MyException1 extends Error{

}

class MyException2 extends RuntimeException{

}

class Book {
    long id;

    public Book(long id) throws BookIdMustPositiveException{
        if (id < 1) {
            throw new BookIdMustPositiveException("id must start from 1.");
        }
        this.id = id;
    }
}

public class TestException {

    // throws: test() doesn't handle exception. whoever calls
    // test() must handle it!
    public static void test() throws CloneNotSupportedException{
        // try-catch: current test() handles exception internally
//        try {
//            throw new CloneNotSupportedException();
//        } catch (CloneNotSupportedException e) {
//            System.err.println(e);
//        }
        throw new CloneNotSupportedException();
    }

    // JVM calls main()
    // JVM will print stack trace of whatever exception it receives
    public static void main(String[] args) throws CloneNotSupportedException{
//        test();

        // prevent a product to be created if price < 0
        try {
            Product product = new Product("iPhone", -100);
            // all codes below will not be executed.
        } catch (IllegalArgumentException e) {

        }

        // if Book class author wants to enforce whoever uses Book
        // to handle Book creation exception, you should throw check exception.
        try {
            Book book = new Book(-10);
        } catch (BookIdMustPositiveException e) {
            System.out.println(e);
        }

        // codes here are executed.
        // if rest of the codes rely on product, then you should stop.
        // if rest of the codes doesn't rely on product, you should continue your app.
        System.out.println("hello world"); // execute no matter book is created or not

        try {
            Product product1 = new Product("iPhone", -100);
            Book book1 = new Book(-1);
        } catch (IllegalArgumentException | BookIdMustPositiveException e) { // only catch two specific exception.
            System.err.println(e);
            // e is final
//            e = null;
        }


        // you can't catch a subclass exception in later catch clause
//        catch (Exception e) {
//            System.err.println(e);
//        } catch (BookIdMustPositiveException e) { // is never reached
//            System.err.println("hi");
//        }

//        catch (IllegalArgumentException e) {
//            System.err.println(e);
//        } catch (BookIdMustPositiveException e) {
//            System.err.println(e);
//        }

        // finally
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            // how to prevent finally to be executed?
//            return; // not work
            System.exit(0);
        } finally {
            // finally clause will always be executed no matter we have exception or not.
            System.out.println("i am always executed.");
        }

    }

}
