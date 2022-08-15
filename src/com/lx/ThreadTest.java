package com.lx;

public class ThreadTest extends Thread {
    public void run(){
        System.out.println("线程启动！");
    }
    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.start();
    }
}
