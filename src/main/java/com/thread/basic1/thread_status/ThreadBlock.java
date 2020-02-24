 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1.thread_status;

 import java.util.concurrent.TimeUnit;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/2/25 1:40 上午
  * @Version
  **/
 public class ThreadBlock extends Thread {
     @Override
     public void run() {
         synchronized (ThreadBlock.class) {
             while (true) {
                 try {
                     TimeUnit.SECONDS.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
 }
