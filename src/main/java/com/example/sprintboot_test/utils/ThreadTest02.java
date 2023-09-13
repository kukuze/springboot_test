package com.example.sprintboot_test.utils;

class MyThread2 implements Runnable{
 
    private int orange = 10;
    private String name;
 
    public MyThread2(String name) {
        this.name = name;
    }
 
    @Override
    public void run() {
        while (orange > 0){
            System.out.println(this.name+"挑走了一个橙子，还剩下"+--orange+"个橙子啦"+Thread.currentThread());
        }
    }
}
 
public class ThreadTest02 {
    public static void main(String[] args) {
//        MyThread2 thread1 = new MyThread2("R姐姐");
//        new Thread(thread1).start();
//        new Thread(thread1).start();
//        new Thread(thread1).start();
//        Thread hello = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        });
//        hello.start();
        Runnable run=()->{
            System.out.println("hello");
        };
        new Thread(()->{
            System.out.println("hello");
        });


    }
}