package com.example.sprintboot_test.dynamicProxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject request");
    }
}