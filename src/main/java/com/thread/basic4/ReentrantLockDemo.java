 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic4;

 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/8 12:16 上午
  * @Version
  **/
 public class ReentrantLockDemo {
     static Lock lock = new ReentrantLock();//N线程来访问

     public void demo() throws InterruptedException {
         lock.lock(); //获得一个锁
         lock.lockInterruptibly();//中断获取锁
         lock.unlock();// 释放锁
     }

     public static void main(String[] args) {

     }
 }
