package com.itmuch.cloud.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Runner implements Callable<Integer> {
    //开始信号
    private CountDownLatch begin;
    private CountDownLatch end;//结束信号

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int core=new Random().nextInt(10);//跑步成绩
        begin.await();
        System.out.println("跑步一起开始跑");
       // TimeUnit.SECONDS.sleep(10);
        end.countDown();//结束跑步
        return core;
    }

    public static void main(String[] args) {

        int num=10;//参加赛跑的人数
        CountDownLatch begin=new CountDownLatch(1);//发令枪只一次发声
        CountDownLatch end=new CountDownLatch(num);
        Runner runner=new Runner(begin,end);
        //每个跑步者一个跑道
        ExecutorService executorService= Executors.newFixedThreadPool(num);
        //记录比赛成绩
        List<Future<Integer>> futureList=new ArrayList<>();
        //等待跑步者就位一起跑步
        for(int i=0;i<num;i++){
            futureList.add(executorService.submit(runner ));
        }
        //发令枪开始响 开始跑步
        begin.countDown();
        //等待所有的跑步完
        try {
            end.wait();
           //end.countDown();
            //开始计算时间
            int count=0;int j=0;
            for(Future<Integer> future:futureList){
                j++;
                Integer score=future.get();
                System.out.println("第"+j+"个人计数为:"+score);
                count+=score;
            }

            System.out.println("总分为："+count);
        }catch (Exception e){

        }

    }
}
