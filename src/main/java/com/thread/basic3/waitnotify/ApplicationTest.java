 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic3.waitnotify;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/5 11:13 上午
  * @Version
  **/
 public class ApplicationTest {
     public static void main(String[] args) {
         Object lock = new Object();
         ThreadA threadA = new ThreadA(lock);
         ThreadB threadB = new ThreadB(lock);
         threadB.start();//阻塞
         threadA.start();//唤醒
     }
 }
