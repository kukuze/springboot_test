package com.example.sprintboot_test.juc;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/2/18 17:32
 */
public class testAtomic {
    public static void main(String[] args) {
        Count count = new Count(0);
        Count2 count2 = new Count2(0);
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Thread> threads2 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            threads.add(new Thread(()->{
                count.increase();
            }));
        }
        for (int i = 0; i < 1000; i++) {
            threads2.add(new Thread(()->{
                count2.increase();
            }));
        }
        threads.forEach(Thread::start);
        threads2.forEach(Thread::start);
        threads.forEach(t->{
            try{
                t.join();
            }catch (Exception e){

            }
        });
        threads2.forEach(t->{
            try{
                t.join();
            }catch (Exception e){

            }
        });
        System.out.println(count.value.get());
        System.out.println(count2.value);
    }

}
class Count{
    AtomicInteger value;

    public Count(int value) {
        this.value = new AtomicInteger(value);
    }
    public void increase(){
        value.incrementAndGet();
    }
}
class Count2{
    Integer value;

    public Count2(Integer value) {
        this.value = value;
    }
    public void increase(){
        value++;
    }
}
