package com.lx;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        NumPrint numPrint = new NumPrint();
        // 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中
        FutureTask<Integer> futureTask = new FutureTask(numPrint);
        new Thread(futureTask).start();

        try{
            System.out.println(futureTask.get());
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}

class NumPrint implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++){
            sum += i;
        }
        return sum;
    }
}