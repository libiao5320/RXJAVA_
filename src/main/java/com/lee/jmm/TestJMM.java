package com.lee.jmm;

/**
 * @author
 * @create 2018-07-25 16:13
 **/
public class TestJMM {
  public static void main(String[] args) {
    SimpleModel simpleModel = new SimpleModel();
    for (int i = 0; i < 100; i++) {
      Thread t1 = new Thread(() -> {
        simpleModel.write();
      }, "t"+i);
      Thread t2 = new Thread(() -> {
        simpleModel.read();
      }, "t"+i+"_" );
      try {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
