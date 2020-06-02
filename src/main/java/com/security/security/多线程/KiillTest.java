package com.security.security.多线程;

public class KiillTest {
    public static void main(String[] args) {
        Hero zhaowei = new Hero();
        zhaowei.name = "伟弟";
        zhaowei.hp = 100;
        zhaowei.deamge = 20;

        Hero huayong = new Hero();
        huayong.name = "华勇";
        huayong.hp = 100;
        huayong.deamge = 30;


        //匿名类重写run方法   实现多线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (!huayong.isDead()) {
                    zhaowei.attackHero(huayong);
                }
            }
        };
        t1.start();


        //实现Runable接口  重写run方法
        KillHeroTest k = new KillHeroTest(huayong, zhaowei);
        new Thread(k).start();
    }
}
