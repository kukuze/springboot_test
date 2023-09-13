package com.example.sprintboot_test.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author CharmingZe
 * @version 1.0
 * @data 2023/3/3 16:50
 */
public class doSomeTask {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ArrayList<Callable<String>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int j=i;
            callables.add(()->{
                Thread.sleep(500);
                System.out.println("每个线程在工作");
                return j+"";
            });
        }
        try{
            List<Future<String>> futures = pool.invokeAll(callables);
            for (int i = 0; i < futures.size(); i++) {
                System.out.println(futures.get(i).get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        pool.shutdown();

    }
}
