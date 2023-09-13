package com.example.sprintboot_test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        Integer[] integerArray = getIntegerArray(1001  );
        int count = 0;
        while (count < integerArray.length) {
            if (count % 2 == 0) {
                if (!maxHeap.isEmpty() && maxHeap.peek() > integerArray[count]) {
                    Integer poll = maxHeap.poll();
                    minHeap.add(poll);
                    maxHeap.add(integerArray[count]);
                } else
                    minHeap.add(integerArray[count]);
            } else {
                if (!minHeap.isEmpty() && minHeap.peek() < integerArray[count]) {
                    Integer poll = minHeap.poll();
                    maxHeap.add(poll);
                    minHeap.add(integerArray[count]);
                } else
                    maxHeap.add(integerArray[count]);
            }
            count++;
        }
        //Integer[] integers = Arrays.stream(integerArray).sorted().toArray(Integer[]::new);
        Integer[] integers = Arrays.stream(integerArray).sorted().toArray(value -> new Integer[value]);
        if (integerArray.length % 2 == 0) {
            System.out.println((float) (minHeap.peek() + maxHeap.peek()) / 2);
            System.out.println((float) (integers[integers.length/2] + integers[integers.length/2-1]) / 2);
        } else {
            System.out.println(minHeap.peek());
            System.out.println(integers[integers.length/2]);
        }

    }

    public static Integer[] getIntegerArray(int length) {
        Integer[] arr = new Integer[length];
        // 数组中最后一个元素是默认的null，就一直去插入元素。
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }

}
