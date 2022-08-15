package com.lx;

import java.util.concurrent.locks.ReentrantLock;

// Lock锁
public class Test4 {
    public static void main(String[] args) {
        ThreadTest4 test = new ThreadTest4();
        Thread test1 = new Thread();
        Thread test2 = new Thread();

        test1.setName("窗口1");
        test2.setName("窗口2");

        test1.start();
        test2.start();
    }
}

class ThreadTest4 extends Thread{
    static int number = 100;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try{
                if (number > 0){
                    System.out.println(currentThread().getName() + " " + number);
                    number--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
