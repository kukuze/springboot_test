package com.example.sprintboot_test;


public class Deadlock {
    public static void main(String[] args) {
        Friend friend = new Friend();
        friend.bow(null);
    }
}
class Friend {
    public synchronized void bow(Friend bower) {
        System.out.println("第一次进入");
        this.bowBack(null);
    }
    public synchronized void bowBack(Friend bower) {
        System.out.println("可重入");
    }
}