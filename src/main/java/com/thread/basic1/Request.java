 /*
  * Copyright (c) 2013, 2019, G42&Totok and/or   its affiliates. All rights reserved.
  * TOTOK PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
  */
 package com.thread.basic1;

 /**
  * @Description
  * @Author YangLee
  * @Date2020/2/25 12:29 上午
  * @Version
  **/
 public class Request {
     private String name;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     @Override
     public String toString() {
         return "Request{" +
                 "name='" + name + '\'' +
                 '}';
     }
 }
