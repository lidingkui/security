package com.security.security.多线程;

public class JoinTest {
    public static void main(String[] args) {
        Hero zhaowei = new Hero();
        zhaowei.name = "伟弟";
        zhaowei.hp = 100;
        zhaowei.deamge = 20;

        Hero huayong = new Hero();
        huayong.name = "华勇";
        huayong.hp = 100;
        huayong.deamge = 30;


        Hero wangzhe = new Hero();
        wangzhe.name = "王者";
        wangzhe.hp = 100;
        wangzhe.deamge = 20;

        Hero yanrui = new Hero();
        yanrui.name = "闫瑞";
        yanrui.hp = 100;
        yanrui.deamge = 30;


       Thread t1 = new Thread() {
           @Override
           public void run() {
               while (!huayong.isDead()) {
                   zhaowei.attackHero(huayong);
               }
           }
       };
       t1.start();


       //首先解释一下主线程的概念
        //所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
        //在43行执行t1.join，即表明在主线程中加入该线程。
        //主线程会等待该线程结束完毕， 才会往下运行。
        //如果不加入该方法的话  两个线程会交替执行   加入join方法的话会等t1线程结束后再执行下面的线程
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (!yanrui.isDead()) {
                    wangzhe.attackHero(yanrui);
                }
            }
        };
        t2.start();
    }
}
