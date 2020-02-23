 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic2;

 /**
  * @Description todo 描述线程的6个生命周期
  * @Author YangLee
  * @Date2020/2/23 1:25 上午
  * @Version
  **/
 public class ThreadLifecycleApplication {
  public static void main(String[] args) {
   try {
    Thread.sleep(100);
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
