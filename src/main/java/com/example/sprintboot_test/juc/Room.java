package com.example.sprintboot_test.juc;

public class Room {
    Integer count=0;
    public static synchronized void a(){
        try {
            Thread.sleep(1000);
            System.out.println("a");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public synchronized void b(){
        System.out.println("b");
    }
    private void test(){
        System.out.println("hello");
    }
}
class House extends Room{

}
