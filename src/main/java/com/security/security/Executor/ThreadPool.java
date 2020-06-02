//package com.security.security.Executor;
//
//import java.util.LinkedList;
//
//public class ThreadPool {
//
//    //线程池大小
//    int threadPoolSize;
//
//    //任务容器
//    LinkedList<Runnable> tasks = new LinkedList<Runnable>();
//
//    public ThreadPool() {
//        threadPoolSize = 10;
//        synchronized (tasks) {
//            for (int i = 0; i < threadPoolSize; i++) {
//                System.out.println(new TaskConsumeThread("任务消费者线程" + i));
//            }
//        }
//    }
//
//}
