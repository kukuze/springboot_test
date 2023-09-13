package com.example.sprintboot_test.utils;

import com.example.sprintboot_test.DesignPattern.ADog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
//    private static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        }, "myThread");
        thread.start();
        System.out.println("xixi");
    }


}