package com.itmuch.cloud.study.controller;




import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool implements Callable<String> {
    private String name;

    public ThreadPool(String name) {
        this.name = name;
    }

    public ThreadPool() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name;
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(100);
        ThreadPool stringCallable=new ThreadPool();
        stringCallable.setName("是对方答复");
        //返回值
        Future<String> funcTrue=executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return stringCallable.name;
            }
        });
        while (!funcTrue.isDone()){
            try {
                System.out.println("返回值："+funcTrue.get());
            }catch (Exception e){

            }

        }

        try {
            System.out.println("返回34值："+funcTrue.get());
        }catch (Exception e){

        }
        executorService.shutdown();
    }
}
