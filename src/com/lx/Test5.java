package com.lx;

// 死锁
public class Test5 {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        Thread test1 = new Thread(thread1);
        Thread test2 = new Thread(thread2);

        test1.start();
        test2.start();
    }
}

class Thread1 implements Runnable{
    static StringBuffer str1 = new StringBuffer();
    static StringBuffer str2 = new StringBuffer();

    @Override
    public void run() {
        synchronized (str1){
            str1.append("a");
            str1.append(1);
        }
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        synchronized (str2){
            str1.append("b");
            str2.append(2);
            System.out.println(str1);
            System.out.println(str2);
        }
    }
}

class Thread2 implements Runnable{
    StringBuffer str1 = Thread1.str1;
    StringBuffer str2 = Thread1.str2;

    // 这里与Thread1相反，使之变为死锁
    @Override
    public void run() {
        synchronized (str2){
            str1.append("c");
            str2.append(3);
        }
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        synchronized (str1){
            str1.append("d");
            str2.append(4);
            System.out.println(str1);
            System.out.println(str2);
        }
    }
}