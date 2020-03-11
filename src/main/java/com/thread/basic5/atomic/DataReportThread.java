 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic5.atomic;

 import java.util.concurrent.BrokenBarrierException;
 import java.util.concurrent.CyclicBarrier;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/12 2:27 上午
  * @Version
  **/
 public class DataReportThread extends Thread {

     private CyclicBarrier cyclicBarrier;
     private String path;


     public DataReportThread(CyclicBarrier cyclicBarrier, String path) {
         this.cyclicBarrier = cyclicBarrier;
         this.path = path;
     }

     @Override
     public void run() {
         System.out.println("开始导入：" + path + "数据");
         try {
             cyclicBarrier.await();//阻塞 condition.await()
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (BrokenBarrierException e) {
             e.printStackTrace();
         }
     }
 }
