 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic3;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/5 11:13 上午
  * @Version
  **/
 public class SyncDemo {

     Object lock = new Object();

     public SyncDemo() {

     }

     //没有同步锁
     public void demo() {
         System.out.println("demo方法开始执行，当前线程为：" + Thread.currentThread().getName());
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("demo方法执行完毕，当前线程为：" + Thread.currentThread().getName());
     }

     public void demo0() {
         synchronized (this) {
             System.out.println("demo0方法开始执行，当前线程为：" + Thread.currentThread().getName());
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
             System.out.println("demo0方法执行完毕，当前线程为：" + Thread.currentThread().getName());
         }
     }

     //demo0()和demo1()效果一样
     public synchronized void demo1() {

         System.out.println("demo1方法开始执行，当前线程为：" + Thread.currentThread().getName());
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         System.out.println("demo1方法执行完毕，当前线程为：" + Thread.currentThread().getName());
     }

     public void demo2() {
         synchronized (lock) {
             System.out.println("demo2方法开始执行，当前线程为：" + Thread.currentThread().getName());
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("demo2方法执行完毕，当前线程为：" + Thread.currentThread().getName());
         }
     }


     public static void main(String[] args) {
         SyncDemo sd = new SyncDemo();
         SyncDemo sd2 = new SyncDemo();
         new Thread(() -> sd.demo2(), "A1").start();
         new Thread(() -> sd.demo2(), "A2").start();
         new Thread(() -> sd2.demo2(), "B1").start();
         new Thread(() -> sd2.demo2(), "B2").start();
     }
 }
