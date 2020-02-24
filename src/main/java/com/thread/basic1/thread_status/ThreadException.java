 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1.thread_status;

 import java.util.concurrent.TimeUnit;

 /**
  * @Description todo 线程的异常中断
  * @Author YangLee
  * @Date2020/2/25 3:03 上午
  * @Version
  **/
 public class ThreadException {

     private static int i;

     public static void main(String[] args) throws InterruptedException {
         Thread thread = new Thread(() -> {
             while (!Thread.currentThread().isInterrupted()) {//默认是false  _interrupted state?

                try {
                    TimeUnit.SECONDS.sleep(10); //中断一个处于阻塞状态的线程。join/wait/queue.take..
                    System.out.println("demo");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                 i++;
             }
             System.out.println("i:" + i);
         });
         thread.start();
         System.out.println("睡2秒之前");
         TimeUnit.SECONDS.sleep(2);
         thread.interrupt(); //把isInterrupted设置成true

         System.out.println(thread.isInterrupted()); //true
     }
 }
