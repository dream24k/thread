package com.lx;

import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 查找文件（线程池测试）
public class FindFile extends Thread{
    public static void main(String[] args) throws InterruptedException{
        // 创建20个线程，20个线程不够会自动增加到30个20，线程停用20s被回收
        ThreadPoolExecutor pool = new ThreadPoolExecutor(20,30,20, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());

        MyTest myTest1 = new MyTest("D:\\test\001");
        MyTest myTest2 = new MyTest("D:\\test\002");

        pool.execute(myTest1);
        pool.execute(myTest2);
    }
}

class MyTest implements Runnable{
    String name = "";
    String fileName = "first.txt";
    static int tag = 0;
    public MyTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        try{
            File file = new File(this.name);
            File[] files = file.listFiles();
            System.out.println("文件查找结果：");
            Find(file);
            if (tag == 1){
                System.out.println("线程" + this.name + "found");
            }else {
                System.out.println("线程" + this.name + "not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void Find(File file){
        File[] files = file.listFiles();
        // isDirectory方法是判断是否为文件夹，是的话深入遍历子文件
        if (file.isDirectory()){
            if (file != null){
                for (File file1 : files){
                    if (file1.getName().equals(fileName)){
                        System.out.println("找到了，文件的路径为：");
                        System.out.println(file1.getAbsolutePath());
                        tag = 1;
                    }
                    Find(file1);
                }
            }
        }
    }
}