package com.mercury.collection;

import java.util.ArrayDeque;
import java.util.Deque;

// "Deck" of cards
public class TestDeque {

    public static void main(String[] args) {
        // Deque: queue/stack
        // ArrayDeque, LinkedList

        // use Deque as queue
        // first in first out
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        // use Deque as stack
        // first in last out
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // new Stack() / new Vector() : terrible performance
    }

}
