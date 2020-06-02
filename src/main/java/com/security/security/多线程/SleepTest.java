package com.security.security.多线程;

public class SleepTest {
    public static void main(String[] args) {
        /*
         *Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响
         *Thread.sleep(1000); 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
         */
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int second = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n" , second);
                }
            }
        };
        t1.start();
    }
}
