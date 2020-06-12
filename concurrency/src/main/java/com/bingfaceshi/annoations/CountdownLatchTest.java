package com.bingfaceshi.annoations;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("我是线程一，一秒后我进入等待状态");
                    countDownLatch.await();
                    Thread.sleep(1000);
                    System.out.println("我是线程一，我等待结束，申请起飞");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("我是线程二，一秒钟后我也进入等待状态");
                    countDownLatch.await();
                    Thread.sleep(1000);
                    System.out.println("我是线程二，等待结束，我申请起飞");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是主线程，我现在减为1");
                for (int i = 0; i < 2; i++) {
                    countDownLatch.countDown();
                }
                System.out.println("我已经减为0了，即将激活线程一和线程二");
            }
        },"主线程").start();
    }
}
