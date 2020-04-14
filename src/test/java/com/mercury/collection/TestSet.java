package com.mercury.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

    public static void main(String[] args) {
        // HashSet: unordered collection contains unique elements.
        // HashSet is implemented using HashMap(keys)
        // LinkedHashSet: ordered set by insertion order
        // TreeSet: sorted set by element(element must be comparable
        // or create TreeSet with custom comparator)
        Set<Integer> set1 = new TreeSet<>();
        set1.add(2); // true
        set1.add(10); // true
        set1.add(2); // false: duplicated element
        set1.add(1);
        System.out.println(set1);
    }

}
