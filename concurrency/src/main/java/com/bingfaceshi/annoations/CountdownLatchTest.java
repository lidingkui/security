package com.bingfaceshi.annoations;

import java.util.concurrent.CountDownLatch;

/*
*  CountDownLatch  就是一把倒计时锁
*  顾名思义就是当所有线程都调用 .await();方法时，阻塞，然后调用 .countDown();
* 方法时释放次数，线程的运行次数是由 CountDownLatch(线程的数量) 这个构造方法来决定的;
* */
public class CountdownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"  我即将进入等待状态.....");
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName()+"  我已经解除等待状态，开始运行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();


        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"   我即将进入等待状态.....");
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName()+"  我已经解除等待状态，开始运行....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" 等待的线程即将全部被唤醒.......");
            for (int i = 0; i < 2; i++) {
                countDownLatch.countDown();
            }
        },"唤醒线程后").start();
    }
}
