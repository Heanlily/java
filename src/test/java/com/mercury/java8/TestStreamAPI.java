package com.mercury.java8;

import com.mercury.oop.Student;
import com.mercury.oop.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamAPI {

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 2, 3, 4, 5};
        // 1. remove duplicates. {1, 2, 3, 4, 5}
        // 2. sort in descending order {5, 4, 3, 2, 1}
        // 3. double all numbers. {10, 8, 6, 4, 2}
        // 4. remove all elements which can be divided by 3. {10, 8, 4, 2}
        // 5. output 2 number from 2nd one. {8, 4}

        // convert array to stream
        // stream will keep send data one by one to operators
        Stream<Integer> arrStream = Arrays.stream(arr);
        // stream.operator()
        // intermediate operator: process data and return stream with processed data.
        // terminal operator: terminate the stream to finish process data
        // for one stream, you can chain multiple intermediate operators, but
        // you can have one terminal operator.
        arrStream.distinct()
                .sorted((a, b) -> b - a) // Comparator
                .map(num -> num * 2) // Function
                .filter(num -> num % 3 != 0) // Predicate
                .skip(1)
                .limit(2)
                .forEach(num -> { // Consumer
                    System.out.println(num);
                });

        // Optional: handle null. avoid NullPointerException
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Optional<Integer> minOp = getMin(list);
        if (minOp.isPresent()) {
            System.out.println(minOp.get() / 2);
        } else {
            System.out.println("You don't have min value!");
        }
        System.out.println(minOp.orElse(0) / 2);
        System.out.println("something after");

        // convert list ot Stream
        Stream<Integer> listStream = list.stream();
        System.out.println(listStream.min((a, b) -> a -b).orElse(Integer.MIN_VALUE));
        //  stream can only be operated / closed once.
        // if you already operate/close the stream, in order to process data again
        // you need to create a new stream.
        listStream = list.stream(); // get a new stream
        System.out.println(listStream.min(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE));

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("bob", 21));
        studentList.add(new Student("alice", 25));
        studentList.add(new Student("alex", 23));
        // sort by age
        // filter by age > 21
        // double the age
        Stream<Student> studentStream = studentList.stream();
        // method reference: syntax sugar to invoke any function
        List<User> processedStudentList = studentStream.sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .filter(s -> s.getAge() > 21)
                .map(s -> {
                    Student student = new Student(s.getName(), s.getAge() * 2);
                    return student;
                })
//                .peek(s -> System.out.println(s))
                .peek(System.out::println)
//                .map(s -> new User(s))
                .map(User::new) // overload. in stream, Student. new Student(Student)
                .collect(Collectors.toList()); // collect all the data in stream as a list
        System.out.println(processedStudentList);

        // stream with generics. array of wrapper primitives/collection.

        // primitive stream: primitive values
        // IntStream, LongStream, DoubleStream
        int[] pArray = {1, 2, 3};
        IntStream intStream = Arrays.stream(pArray);
        System.out.println(intStream.min().orElse(0));

        String[][] array = {{"bob", "23", "45", "98"}, {"ben", "90"}, {"ketty", "78"}};
        System.out.println(getBestAverageScore(array));

        // parallel stream
    }

    public static int getBestAverageScore(String[][] array) {
        return -1;
    }

    // enhance getMin which will require caller to handle null case.
    // Optional: an object which may contain a value or empty.
    private static Optional<Integer> getMin(List<Integer> list) {
//        if (list == null || list.size() == 0) {
//            return Optional.empty();
//        }
//        Collections.sort(list);
//        return Optional.of(list.get(0));

        Integer result = null;
        if (list == null || list.size() == 0) {
            result = null;
        }
        Collections.sort(list);
        result = list.get(0);
        return Optional.ofNullable(result);
    }

}
