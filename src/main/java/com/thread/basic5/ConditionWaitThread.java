 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic5;

 import java.util.concurrent.locks.Condition;
 import java.util.concurrent.locks.Lock;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/8 1:03 上午
  * @Version
  **/
 public class ConditionWaitThread implements Runnable {
     private Lock lock;
     private Condition condition;

     public ConditionWaitThread(Lock lock, Condition condition) {
         this.lock = lock;
         this.condition = condition;
     }

     @Override
     public void run() {
         try {
             lock.lock();
             System.out.println("begin wait");
             condition.await();
             System.out.println("end wait");
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
     }
 }
