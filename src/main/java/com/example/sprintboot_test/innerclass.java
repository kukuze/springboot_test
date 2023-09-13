package com.example.sprintboot_test;

import java.util.ArrayList;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/15 17:36
 */
public class innerclass {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        int a=0;
        for (int i = 0; i <5; i++) {
            int j=i;
            new Thread(()->{
                System.out.println(objects);
            },"t"+i).start();
        }
    }
}
