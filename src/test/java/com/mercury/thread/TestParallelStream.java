package com.mercury.thread;

import java.util.ArrayList;
import java.util.List;

public class TestParallelStream {

	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		for (long i = 0; i < 1000; i++) {
			list.add(i);
		}
		
		long startTime = System.currentTimeMillis(); // 01/01/1970 00:00
		System.out.println(
			list.stream().reduce(0l, (a, b) -> {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return a + b;
			})
		);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		System.out.println(
			// how to ask CPU to run 4 threads in parallel???
			// forkAndJoin: 2cores * 2= 4threads
			// since java 1.8, parallelStream() will internally instruct CPU
			// to maximize its capability by running as many threads as possible at same same.
			list.parallelStream().reduce(0l, (a, b) -> {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return a + b;
			})
		);
		endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime) + "ms");
	}

}
