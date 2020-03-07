 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic3;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/3/5 11:14 上午
  * @Version
  **/
 public class Test implements Runnable {
     private static volatile boolean isRunning = false; //中断标识

     @Override
     public void run() {
         while (!isRunning) { //!true
             //TODO
         }

     }

     public static void main(String[] args) {
         System.out.println("test");

         Thread thread = new Thread();


         thread.interrupt();//isRunning=true;
     }
 }
