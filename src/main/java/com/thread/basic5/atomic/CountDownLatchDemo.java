 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic5.atomic;

 import java.util.concurrent.CountDownLatch;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/10 12:10 上午
  * @Version
  **/
 public class CountDownLatchDemo extends Thread {

//     static CountDownLatch countDownLatch = new CountDownLatch(2);
     static CountDownLatch countDownLatch = new CountDownLatch(1);

     @Override
     public void run() {
         try {
             countDownLatch.await();//阻塞  5个线程 Thread.currentThread
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

         System.out.println("ThreadName:" + Thread.currentThread().getName());
     }

     public static void main(String[] args) {
         for (int i = 0; i < 5; i++) {
             new CountDownLatchDemo().start();
         }
         System.out.println("线程都启动完毕");
         countDownLatch.countDown();//countdownlatch值为0，才会启动全部阻塞线程

     }
 }
