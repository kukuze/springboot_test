package com.example.sprintboot_test.dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                invocationHandler);
        proxySubject.request();
    }
}