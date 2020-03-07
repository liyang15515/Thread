 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic3.waitnotify;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/5 11:12 上午
  * @Version
  **/
 public class ThreadA extends Thread {
     private Object lock = new Object();

     public ThreadA(Object lock) {
         this.lock = lock;
     }

     @Override
     public void run() {
         synchronized (lock) {
             System.out.println("start ThreadA");
             lock.notify();//唤醒被阻塞的线程
             System.out.println("end ThreadA");
         }
     }
 }
