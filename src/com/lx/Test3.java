package com.lx;

// 给买票操作加上synchronized
public class Test3 {
    public static void main(String[] args) {
        ThreadTest3 test = new ThreadTest3();
        Thread window1 = new Thread(test);
        Thread window2 = new Thread(test);

        window1.setName("窗口1");
        window2.setName("窗口2");

        window1.start();
        window2.start();
    }
}

class ThreadTest3 implements Runnable{
    int ticket = 10000;

    @Override
    public void run() {
        while (ticket > 0){
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + "售出" + ticket + "张票");
                ticket--;
            }
        }
    }
}