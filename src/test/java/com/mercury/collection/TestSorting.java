package com.mercury.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        list1.add(3);
        System.out.println(list1);
        // helper class
        // default sorting rule: sort elements in ascending order
        Collections.sort(list1);
        System.out.println(list1);

        // how to sort the list in descending order?
        // defined custom sorting rule(comparision rule)
        // when java compares two elements and decide which element element
        // should be in front of another.
        // compare(1, 4). 4 - 1 > 0 => 1 after 4
        MyDescSortingRule myDescSortingRule = new MyDescSortingRule();
        Collections.sort(list1, myDescSortingRule);

        List<String> l2 = new ArrayList<>();
        l2.add("bob");
        l2.add("alice");
        l2.add("alex");
        // sort l2 in nature order ascendingly.
        Collections.sort(l2);
        System.out.println(l2);
        // how to sort l2 based on character numbers in string?
        // use anonymous inner class to create a temporary class
        // to define custom comparison rules.
        Comparator<String> comparisonRuleBasedOnCharsLength = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Collections.sort(l2, comparisonRuleBasedOnCharsLength);
        System.out.println(l2);

        // Alex, Alice3, Alice2, Alice1, Bob

        List<User> list3 = new ArrayList<>();
        list3.add(new User("Alex", 21, 80.0f));
        list3.add(new User("Bob", 18, 90.0f));
        list3.add(new User("Alice", 25, 100.0f));
        list3.add(new User("Alice", 23, 90.0f));
        list3.add(new User("Alice", 23, 80.0f));
        // compile error: can't tell which user is bigger or smaller

        // comparison rule: sort user by age.
        Comparator<User> sortByAge = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Collections.sort(list3, sortByAge);
        System.out.println(list3);

        // default comparsion rule (compareTo() from Comparable)
        // will be used
        Collections.sort(list3);
        System.out.println(list3);

        // create a custom comparsion rule
        // compare two users first by name, then by age, last by score.
    }

}
