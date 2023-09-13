package com.example.sprintboot_test.juc;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/20 17:42
 */
public class Reference {
    public final static AtomicMarkableReference<String> refer = new AtomicMarkableReference<String>("abc", false);

    public static void main(String[] args) throws InterruptedException {
        //假设以下操作由不同线程执行
        boolean marked = refer.isMarked();
        new Thread(()->{
            refer.compareAndSet("abc","abc2",false,true);
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            refer.compareAndSet("abc2","abc3",true,false);
        }).start();
        Thread.sleep(1000);
        boolean b = refer.compareAndSet("abc", "abc2", marked, !marked);
        System.out.println(b);
        System.out.println(refer.getReference());
        BigDecimal one=new BigDecimal("100");
        one.subtract(BigDecimal.ONE);
    }
}
