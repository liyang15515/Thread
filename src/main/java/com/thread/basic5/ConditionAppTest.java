 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic5;

 import java.util.concurrent.locks.Condition;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;

 /**
  * @Description lock的wait和notify    condition实现的线程之间的通信
  * @Author YangLee
  * @Date2020/3/8 1:09 上午
  * @Version
  **/
 public class ConditionAppTest {
     public static void main(String[] args) {
      Lock lock = new ReentrantLock();
      Condition condition = lock.newCondition();
      new Thread(new ConditionWaitThread(lock,condition)).start();//阻塞await
      new Thread(new ConditionNotifyThread(lock,condition)).start();//通知
     }
 }
