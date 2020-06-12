package com.bingfaceshi.test;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class CountExample {
    private static int threadTotal = 1;
    private static int clientTotal = 5000;
    private static long count = 0;
//    private static Map<Integer, Integer> map = Maps.newHashMap();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private  static void add() {
        count++;
    }
}
