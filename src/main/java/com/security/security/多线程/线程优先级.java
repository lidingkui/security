package com.security.security.多线程;
/*
//设置线程的最小优先级  MIN_PRIORITY =1  最小优先级
//设置线程的最大优先级  MAX_PRIORITY =10 最大优先级
// 当然还有默认优先级   默认为5
*/
public class 线程优先级 {
    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61;
        gareen.deamge = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 45;
        teemo.deamge = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50;
        bh.deamge = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 45;
        leesin.deamge = 1;

        Thread t1= new Thread(){
            @Override
            public void run(){

                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2= new Thread(){
            @Override
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };

        //设置线程的最小优先级  MIN_PRIORITY =1  最小优先级
        //设置线程的最大优先级  MAX_PRIORITY =10 最大优先级
        // 当然还有默认优先级   默认为5
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
        t1.start();
    }
}
