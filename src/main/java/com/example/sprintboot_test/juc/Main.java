package com.example.sprintboot_test.juc;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        new Thread(()->{
            room.a();
        }).start();
        new Thread(()->{
            room.b();
        }).start();
    }
}
