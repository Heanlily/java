package com.mercury.collection;

import java.util.Comparator;

public class MyDescSortingRule implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        // 0: o1 == o2
        // > 0: o1 should be after o2
        // < 0: o1 should be in front of o2
        return o2 - o1;
    }
}
