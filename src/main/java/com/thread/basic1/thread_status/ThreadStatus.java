 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1.thread_status;

 import java.util.concurrent.TimeUnit;

 /**
  * @Description  todo 线程的6个状态
  * @Author YangLee
  * @Date2020/2/25 1:38 上午
  * @Version
  **/
 public class ThreadStatus {
     public static void main(String[] args) {
         new Thread(() -> {
             while (true) {
                 try {
                     TimeUnit.SECONDS.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }, "Time_Waiting_Thread").start();
         new Thread(() -> {
             while (true) {
                 synchronized (ThreadStatus.class) {//调用wait()方法一定要获得锁synchronized，不然会报错的。
                     try {
                         ThreadStatus.class.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }, "Wating_Thread").start();
      //BLOCKED
      new Thread(new ThreadBlock(),"Blocke01_Thread").start();
      new Thread(new ThreadBlock(),"Blocke02_Thread").start();
     }
 }
