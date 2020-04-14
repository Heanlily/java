package com.mercury.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        // any collection whose iterator will throw ConcurrentModificationException
        // if collection's structure is changed after iterator is created.
        // then this collection's iterator is fail-fast iterator.

        // t1
        Iterator<Integer> iterator = list.iterator(); // create iterator. list has 3 elements.
        while (iterator.hasNext()) { // java is confused
            Integer data = iterator.next();
            System.out.println(data);
        }

        // t2
        list.add(4); // change collection structure. list has 4 elements


    }

}
