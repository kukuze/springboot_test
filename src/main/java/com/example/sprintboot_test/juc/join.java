package com.example.sprintboot_test.juc;

public class join {
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            while (true) {

            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join(5000);
                System.out.println("hello");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
//        Thread.sleep(1000);
//        thread1.interrupt();
////        thread.join();
//        thread.join();
//        thread1.join();
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }
}
