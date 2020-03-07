 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic4;

 import java.util.*;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantReadWriteLock;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/8 12:17 上午
  * @Version
  **/
 public class ReadWriteLockDemo {
     static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
     static Lock readLock = readWriteLock.readLock();
     static Lock writeLock = readWriteLock.writeLock();
     static Map<String, Object> cacheMap = new HashMap<>();

     //线程B/C/D
     public static final Object get(String key) {
         System.out.println("begin read data:" + key);
         readLock.lock(); //获得读锁-> 阻塞
         try {
             return cacheMap.get(key);
         } finally {
             readLock.unlock();
         }
     }

     //线程A
     public static final Object put(String key, Object val) {
         writeLock.lock();//获得了写锁
         try {
             return cacheMap.put(key, val);
         } finally {
             writeLock.unlock();
         }
     }
  public static void main(String[] args) {
   readWriteLock.readLock();//B线程 ->阻塞

   readWriteLock.writeLock(); //A线程

   //读->读是可以共享
   //读->写 互斥
   //写->写 互斥
   //读多写少的场景
  }
 }
