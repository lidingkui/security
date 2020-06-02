package com.security.security.多线程;
/*
* 当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源
* 如果有两个线程的话   其中一个线程yeild的话就是把cpu让给了另一个线程优先使用
*/
public class YieldTest {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61600;
        gareen.deamge = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 30000;
        teemo.deamge = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50000;
        bh.deamge = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 45050;
        leesin.deamge = 1;

        Thread t1= new Thread(){
            @Override
            public void run(){

                while(!teemo.isDead()){
                    //临时暂停，使得t2可以占用CPU资源
                    Thread.yield();
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
        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();
    }
}
