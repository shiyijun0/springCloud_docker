package com.itmuch.cloud.study.controller;

import java.util.concurrent.*;

public class TaskCal implements Callable<Integer> {
    private int seddMoney;//本金

    public TaskCal(int seddMoney) {
        this.seddMoney = seddMoney;
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return seddMoney/10;
    }

    public static void main(String[] args) {
        //生成单线程异步执行器
        ExecutorService executorService=Executors.newSingleThreadExecutor();
//线程执行后的期望值
        Future<Integer> future=executorService.submit(new TaskCal(100));
        while (!future.isDone()){
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            }catch (InterruptedException e){
                System.out.println(e.fillInStackTrace());
            }

            System.out.println("*******");
        }
try {
    System.out.println("***jis******"+future.get());
}catch (InterruptedException e){

}catch (ExecutionException e){

}
finally {
    executorService.shutdown();
}


    }
}
