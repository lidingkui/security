package com.security.security.多线程;

import java.util.concurrent.Callable;

/*
* 实现多线程的三种方式
* 1： 继承Thread 类  重写run 方法
* 2： 实现Runnable接口  重写run方法
* 3： 利用匿名类   重写run 方法
* 4： 还可以实现Callable接口    重写call方法
* 5:  还可以通过创建线程池来
*/
public class KillHeroTest implements Runnable {
    private Hero h1;
    private Hero h2;

    //创建构造方法把两个对象传进去
    public KillHeroTest(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }


    @Override
    public void run() {
        while (!h2.isDead()) {
            h1.attackHero(h2);
        }
    }
}
