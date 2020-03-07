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
 public class ThreadB extends Thread {
     private Object lock = new Object();

     public ThreadB(Object lock) {
         this.lock = lock;
     }

     @Override
     public void run() {
         synchronized (lock) {
             System.out.println("start ThreadB");
             try {
                 lock.wait(); //实现线程的阻塞
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("end ThreadB");
         }
     }
 }
