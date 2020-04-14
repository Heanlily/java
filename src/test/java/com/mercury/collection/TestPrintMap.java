package com.mercury.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestPrintMap {

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("bob", 80);
        scores.put("alice", 100);
        scores.put("zack", 90);

        // how to print each key-value pair line by line in a map???
        // 1. keySet() - return a set of all the keys in the map.
        Set<String> keys = scores.keySet();
        for (String key : keys) {
            System.out.println(key + " - " + scores.get(key));
        }
        // 2. entrySet() - return a set of all the entries(nodes) in map.
        // Node<K, V> implements Map.Entry<K, V>
        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        // 3. forEach(BiConsumer)
    }

}
