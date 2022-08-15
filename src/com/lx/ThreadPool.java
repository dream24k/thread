package com.lx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        // 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // 设置线程池的属性
//        System.out.println(service.getClass()); // 核心池的大小
//        service1.setCorePoolSize(15);           // 最大线程数

        // 执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
        // service.submit(Callable callable); 适用于Callable

        // 关闭线程池
        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName() + ":" +i);
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" +i);
            }
        }
    }
}