 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic3;

 import java.util.concurrent.locks.Lock;

 /**
  * @Description 类锁
  * @Author YangLee
  * @Date2020/3/3 5:01 下午
  * @Version
  **/
 public class AtomicCrease {
     private static int count = 0;

     public synchronized static void incr0() {
         try {
             Thread.sleep(1);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         count++;
     }
     //incr0()和incr2()方法是一样效果
     public  static void incr2() {
         synchronized (AtomicCrease.class) {
             try {
                 Thread.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         count++;
     }
     public  static void incr1() {
         try {
             Thread.sleep(1);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         count++;
     }

     public static void main(String[] args) throws InterruptedException {
         for (int i = 0; i < 1000; i++) {
             new Thread(() -> AtomicCrease.incr2()).start();
         }
         Thread.sleep(2000);

         System.out.println("total运行结果：" + count);
     }
 }
