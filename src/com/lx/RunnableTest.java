package com.lx;

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口！");
    }

    public static void main(String[] args) {
        Thread test = new Thread(new RunnableTest());
        test.start();
    }
}
