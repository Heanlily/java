package com.mercury.collection;

import java.util.*;

public class TestMap {

    static class Book{
        private String name;
        private int price;

        public Book(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.price;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Book) {
                Book another = (Book) obj;
                // "learn css", "learn css"
                return this.name.equals(another.name)
                        && this.price == another.price;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // key-value pairs
        // key must be unique
        // map never has two pairs with same key
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1); // first pair
        map.put(2, 1); // second pair
        map.put(1, 3); // update the value of first pair

        // book - sales
        Book b1 = new Book("learn js", 20);
        Book b2 = new Book("learn java", 30);
        // we want to consider two books with same
        // name and same price to be matching
        Book b3 = new Book("learn css", 10);
        Book b4 = new Book("learn css", 10);
        Book b5 = new Book("learn csa", 28);
        Map<Book, Integer> bookSales = new HashMap<>();
        bookSales.put(b1, 200);
        bookSales.put(b2, 400);
        bookSales.put(b3, 600);
        bookSales.put(b4, 300);
        bookSales.put(b5, 900);
        // 1. b3 and b4 are consider as different key
        // 2. HashMap does not reserve insertion order.(sorted)
        System.out.println(bookSales);

        System.out.println(b1.hashCode()); // 1836019240
        System.out.println(b2.hashCode()); // 325040804
        System.out.println(b3.hashCode() == b4.hashCode()); // false

        System.out.println(calc(b1.hashCode()));
        System.out.println(calc(b2.hashCode()));
        System.out.println(calc(b3.hashCode()));
        System.out.println(calc(b4.hashCode()));
        System.out.println(calc(b5.hashCode()));

        System.out.println(hash(b3.hashCode()));
        System.out.println(hash(b4.hashCode()));
        System.out.println(hash(b5.hashCode()));


        // keys' hashcode are different, indies may be different or same.
        // indies which are calculated are different, keys' hash must be different

        // TreeMap
        // sorted map by key
        // The key must be Comparable or create map with custom comparator
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        Map<String, Integer> scores = new TreeMap<>(comparator);
        scores.put("bob", 80);
        scores.put("alice", 100);
        scores.put("zack", 90);
        System.out.println(scores);

        // LinkedHashMap: sorted map by insertion order

        Map<String, Integer> scores1 = new HashMap<>();
        scores1.put("alice", 90);
        scores1.put("bob", 80);
        scores1.put("zack", 100);
        // your codes start here

        System.out.println(scores1); // sorted by score1(value)
    }

    static int hash(int hashcode) {
        return (hashcode ^ (hashcode >>> 16));
    }

    static int calc(int i) {
        return hash(i) & 15;
    }

}
