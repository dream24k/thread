package com.lx;

// 优先级
public class Test1 extends Thread{
    public static void main(String[] args) {
        Thread test = new Thread(new ThreadTest1());
        test.setName("线程一");
        test.setPriority(3);
        test.start();
    }
}

class ThreadTest1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "\t" + i + "优先级是：" + Thread.currentThread().getPriority());
            }
        }
    }
}
