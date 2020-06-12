package com.security.security.Exception;

import java.util.concurrent.TimeUnit;

public class Singleton {
    private static final Object A = new Object();
    private static  final  Object B = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A) {
                System.out.println("我是A线程，我需要请求起飞");
                System.out.println("A线程1秒后起飞");
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("我是B线程，我需要轻轻起飞");
                    System.out.println("B线程1秒后起飞");
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread1").start();

        new Thread(()->{
            synchronized (B) {
                System.out.println("B线程已经就绪，请求起飞");
                System.out.println("B线程将在一秒钟之后起飞");
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("我是A线程，我请求起飞");
                    System.out.println("A线程1秒以后 请求起飞");
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Thread2").start();
    }
}
