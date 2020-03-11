 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic5.atomic;

 import java.util.concurrent.CyclicBarrier;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/12 2:28 上午
  * @Version
  **/
 public class CycliBarrierDemo extends Thread {
     @Override
     public void run() {
         System.out.println("开始进行数值分析了");
     }

     //循环屏障
     //可以使得一组线程达到一个同步点之前阻塞.
     public static void main(String[] args) {
      CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new CycliBarrierDemo());
      new DataReportThread(cyclicBarrier,"file1").start();
      new DataReportThread(cyclicBarrier,"file2").start();
      new DataReportThread(cyclicBarrier,"file3").start();
     }
 }
