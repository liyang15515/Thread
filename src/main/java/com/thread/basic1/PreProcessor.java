 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1;

 import java.util.concurrent.LinkedBlockingQueue;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/2/25 12:32 上午
  * @Version
  **/
 public class PreProcessor extends Thread implements RequestProcessor {
     //阻塞队列
     LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();
     private  RequestProcessor nextProcessor;

     public PreProcessor(RequestProcessor nextProcessor) {
         this.nextProcessor = nextProcessor;
     }

     private volatile boolean isFinish = false;

     public void shutDown(boolean finish) {//对外提供关闭的方法
         isFinish = true;
     }

     @Override
     public void run() {
         while (!isFinish) {
             try {
                 Request request = requests.take();//阻塞获取请求数据，所以会抛出InterruptedException异常
                 //处理业务逻辑
                 System.out.println("prevProcessor:" + request);
                 nextProcessor.process(request);//交给下一个责任链处理请求
             } catch (InterruptedException e) {
                 System.out.println("所有与阻塞相关的线程代码都会抛出一个InterruptException");
             }
         }
     }

     @Override
     public void process(Request request) {
         System.out.println("验证请求参数");
         requests.add(request);
     }
 }
