package com.security.security;

import com.security.security.Lambda.Hero;

/*
* 死锁
*  1. 线程1 首先占有对象1，接着试图占有对象2
   2. 线程2 首先占有对象2，接着试图占有对象1
   3. 线程1 等待线程2释放对象2
   4. 与此同时，线程2等待线程1释放对象1
*/
public class DeadLock {
    public static void main(String[] args) {
        final Hero ahri = new Hero();
        ahri.name = "九尾妖狐";

        final Hero annie = new Hero();
        annie.name = "安妮";

        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (ahri) {
                    System.out.println("t1 已经占有九尾妖狐");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有安妮");
                    System.out.println("t1 等待中 。。。。");
                    synchronized (annie) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("t2 线程已经占有安妮");
                synchronized (annie) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有安妮");
                    System.out.println("t2 等待中 。。。。");
                    synchronized (ahri) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();
    }
}
