 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic4;

 /**
  * @Description synchronized也支持重入锁
  * @Author YangLee
  * @Date2020/3/8 12:16 上午
  * @Version
  **/
 public class App {
     public synchronized void demo() {//main获得对象锁
         System.out.println("demo");
         demo2();
     }

     public void demo2() {
         synchronized (this) {//增加重入次数就行（这里不需要重新获得锁，只要增加重入锁的次数）
             System.out.println("demo2");
         }//减少重入次数
     }

     public static void main(String[] args) {
         App app = new App();
         app.demo();
     }
 }
