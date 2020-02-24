 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1;

 /**
  * @Description todo 责任链模式描述线程工作流
  * @Author YangLee
  * @Date2020/2/22 11:28 下午
  * @Version
  **/
 public class Application {
     PrintProcessor printProcessor;
     SaveProcessor saveProcessor;
     PreProcessor preProcessor;
     static RequestProcessor requestProcessor;

     public Application() {

     }
     public void startUp(){
         printProcessor = new PrintProcessor();
         saveProcessor = new SaveProcessor(printProcessor);
         printProcessor.start();
         saveProcessor.start();
         requestProcessor = new PreProcessor(saveProcessor);
         ((PreProcessor) requestProcessor).start();
     }

     public static void main(String[] args) {
         Application application = new Application();
         application.startUp();
         Request request = new Request();
         request.setName("yanglee");
         requestProcessor.process(request);
     }
 }
