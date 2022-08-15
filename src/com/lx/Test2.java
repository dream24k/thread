package com.lx;

// 通过Runnable接口实现买票操作
public class Test2 {
    public static void main(String[] args) {
        ThreadTest2 test = new ThreadTest2();
        Thread window1 = new Thread(test);
        Thread window2 = new Thread(test);

        window1.setName("窗口1");
        window2.setName("窗口2");

        window1.start();
        window2.start();
    }
}

class ThreadTest2 implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        while(ticket > 0){
            System.out.println(Thread.currentThread().getName() + "售出" + ticket + "张票");
            ticket--;
        }
    }
}