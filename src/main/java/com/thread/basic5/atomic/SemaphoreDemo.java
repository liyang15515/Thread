 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic5.atomic;

 import java.util.concurrent.Semaphore;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/12 2:27 上午
  * @Version
  **/
 public class SemaphoreDemo {
     //限流（AQS）

     //permits; 令牌(5)

     //公平和非公平

     public static void main(String[] args) {
         Semaphore semaphore = new Semaphore(5);
         for (int i = 1; i <= 10; i++) {
             new Car(i, semaphore).start();
         }
     }

     static class Car extends Thread {
         private int num;
         private Semaphore semaphore;

         public Car(int num, Semaphore semaphore) {
             this.num = num;
             this.semaphore = semaphore;
         }

         @Override
         public void run() {
             try {
                 semaphore.acquire();//获得一个令牌, 如果拿不到令牌，就会阻塞
                 System.out.println("第" + num + "辆车进来了");
                 Thread.sleep(3000);
                 System.out.println("第" + num + "辆车出去了");
                 semaphore.release();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         }
     }
 }
