 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1.thread_status;

 import java.util.concurrent.TimeUnit;

 /**
  * @Description todo 线程的复位
  * @Author YangLee
  * @Date2020/2/25 2:55 上午
  * @Version
  **/
 public class ThreadReset {
     public static void main(String[] args) throws InterruptedException {
      Thread thread=new Thread(()->{
       while(true){//默认是false  _interrupted state?
        if(Thread.currentThread().isInterrupted()){
         System.out.println("before:"+Thread.currentThread().isInterrupted());
         Thread.interrupted(); //复位- 回到初始状态
         System.out.println("after:"+Thread.currentThread().isInterrupted());
        }
       }
      });
      thread.start();
      TimeUnit.SECONDS.sleep(5);
      System.out.println("111111");
      thread.interrupt(); //把isInterrupted设置成true
      System.out.println("2222222");
     }
 }
