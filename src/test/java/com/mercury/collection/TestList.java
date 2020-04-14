package com.mercury.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        // coding against interface/super class
        List<Integer> list1 = new ArrayList<>(); // lazy allocation
        list1.add(2); // 2 -> autoboxing -> new Integer(2)
        list1.add(1);
        list1.add(3);
        list1.add(1, 4);
        System.out.println(list1);
        System.out.println(list1.get(2));

        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list2.add(1);
        list2.add(3);
        System.out.println(list2);
        System.out.println(list2.get(2));

        // how to iterate over/loop through a list?
        // 3 ways
        // 1. for-loop
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        // 2. enhanced for loop
        for (Integer num : list1) {
            System.out.println(num);
        }
        // 3. iterator
        // for any collection, java create an iterator object automatically
        // cursor
        Iterator<Integer> it = list1.iterator();
        // hasNext()
        // next()
        while (it.hasNext()) {
            Integer data = it.next();
            System.out.println(data);
        }
    }

}
