package com.xiaxin.ch03;

public class Singleton {
   private static Singleton instance = null;//多个线程共享instance
   private Singleton() {}
   public static Singleton getInstance() {
       if (instance == null){
           synchronized(Singleton.class){
              if (instance == null)
                  instance = new Singleton();
               }
         }
         return instance;
     }
}