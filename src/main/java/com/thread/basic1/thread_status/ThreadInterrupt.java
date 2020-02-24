 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1.thread_status;

 import java.util.concurrent.TimeUnit;

 /**
  * @Description todo 线程的中断
  * @Author YangLee
  * @Date2020/2/25 2:29 上午
  * @Version
  **/
 public class ThreadInterrupt {
     private static int i;

     public static void main(String[] args) {
         Thread thread = new Thread(() -> {
             while (!Thread.currentThread().isInterrupted()) {
                 i++;
             }
          System.out.println("i:"+i);
         });
         thread.start();
      try {
       TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
       e.printStackTrace();
      }
      thread.interrupt();
     }
 }
