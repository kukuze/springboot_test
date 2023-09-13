
package com.example.sprintboot_test.DesignPattern;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @author lx
 */
public class ArrayDequeTest2 {
    static ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
    static LinkedList<Integer> linkedList = new LinkedList<Integer>();


    public static long arrayDequeAdd() {
        //开始时间
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 5000000; i++) {
            arrayDeque.addLast(i);
            arrayDeque.addFirst(i);
        }
        //结束时间
        long endTime = System.currentTimeMillis();
        //返回所用时间
        return endTime - startTime;
    }

    public static long arrayDequeDel() {
        //开始时间
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 5000000; i++) {
            arrayDeque.pollFirst();
            arrayDeque.pollLast();
        }
        //结束时间
        long endTime = System.currentTimeMillis();
        //返回所用时间
        return endTime - startTime;
    }

    public static long linkedListAdd() {
        //开始时间
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 5000000; i++) {
            linkedList.addLast(i);
            linkedList.addFirst(i);
        }
        //结束时间
        long endTime = System.currentTimeMillis();
        //返回所用时间
        return endTime - startTime;
    }

    public static long linkedListDel() {
        //开始时间
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 5000000; i++) {
            linkedList.pollFirst();
            linkedList.pollLast();
        }
        //结束时间
        long endTime = System.currentTimeMillis();
        //返回所用时间
        return endTime - startTime;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100);
        long time1 = arrayDequeAdd();
        long time3 = arrayDequeDel();
        System.out.println("arrayDeque添加元素所用时间====>" + time1);
        System.out.println("arrayDeque删除元素所用时间====>" + time3);
        System.gc();
        Thread.sleep(100);
        long time2 = linkedListAdd();
        long time4 = linkedListDel();
        System.out.println("linkedList添加元素所用时间====>" + time2);
        System.out.println("linkedList删除元素所用时间====>" + time4);
    }
}
