package com.security.security.多线程;

public class TestThread {
    public static void main(String[] args) {
        final Hero zhaowei = new Hero();
        zhaowei.name = "赵伟";
        zhaowei.hp = 100;
        zhaowei.deamge = 20;

        final Hero huayong = new Hero();
        huayong.name = "华勇";
        huayong.hp = 100;
        huayong.deamge = 20;


        final Hero wangzhe = new Hero();
        wangzhe.name = "王者";
        wangzhe.hp = 200;
        wangzhe.deamge = 50;


        final Hero yanrui = new Hero();
        yanrui.name = "闫瑞";
        yanrui.hp = 400;
        yanrui.deamge = 30;

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (!huayong.isDead()) {
                    zhaowei.attackHero(huayong);
                }
            }
        };
        t1.start();


//        //在没有加入join方法之前两个线程是并行执行的，不分先后，在加入join方法之后必须等到第一个线程结束之后才可以执行下一个线程
//        try {
//            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
//            t1.join();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (!yanrui.isDead()) {
                    //临时停掉，使得t1可以占用cpu资源
                    Thread.yield();
                    wangzhe.attackHero(yanrui);
                }
            }
        };
        t2.start();
    }
}
