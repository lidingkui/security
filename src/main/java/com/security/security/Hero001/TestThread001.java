package com.security.security.Hero001;

public class TestThread001 {
    public static void main(String[] args) {
      final Hero001 green = new Hero001();
        green.name = "九尾妖狐";
        green.hp = 667;

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    green.hurt();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();


        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    green.recover();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
    }
}

