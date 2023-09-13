package com.example.sprintboot_test;

public class OuterClass {
    private static Runnable runnable;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            test(i);
        }
    }
    public static void test(int a){
        if(a==3) {
            throw new RuntimeException("1");
        }
        System.out.println(a);
    }


}
