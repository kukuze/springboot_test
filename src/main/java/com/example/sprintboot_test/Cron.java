package com.example.sprintboot_test;


import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@EnableScheduling
@Service
@EnableAsync
public class Cron {
    ReentrantReadWriteLock lock;
    Condition readCondition;
    HashMap <String,String>map;
    volatile boolean isWriting;
    @PostConstruct
    public void init() {
        lock = new ReentrantReadWriteLock();
        readCondition = lock.writeLock().newCondition();
        isWriting = true;
        map= new HashMap<>();
    }

//    @Async
//    @Scheduled(fixedDelayString = "1500")
//    public void write() {
//        isWriting=true;
//        lock.writeLock().lock();
//        System.out.println("线程将开始写啦");
//        try {
//            map.put("1","1");
//            map.put("2","2");
//            map.put("3","3");
//        } finally {
//            isWriting=false;
//            readCondition.signalAll();
//            lock.writeLock().unlock();
//            System.out.println("线程写完啦");
//        }
//    }
//    @Async
//    @Scheduled(fixedDelayString = "1000")
//    public void read1() throws InterruptedException {
//        lock.readLock().lock();
//        try {
//            while (isWriting) {
//                readCondition.await();
//            }
//            System.out.println("线程1"+map.get("1"));
//        } finally {
//            lock.readLock().unlock();
//        }
//    }
//    @Async
//    @Scheduled(fixedDelayString = "1000")
//    public void read2() throws InterruptedException {
//        lock.readLock().lock();
//        try {
//            while (isWriting) {
//                readCondition.await();
//            }
//            System.out.println("线程2"+map.get("2"));
//        } finally {
//            lock.readLock().unlock();
//        }
//    }


}
