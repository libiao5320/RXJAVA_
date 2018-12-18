package com.lee.jmm;

/**
 * @author
 * @create 2018-07-25 16:11
 **/
public class SimpleModel {


  private volatile int _a = 1;
  private boolean flag = false;


  public synchronized void write() {

    this._a = 5;
    this.flag = true;

    System.out.println(Thread.currentThread().getName() + " write ");
  }


  public synchronized void read() {
    if (this.flag) {
      System.out.println(Thread.currentThread().getName() + " read " + (_a * _a));
      reset();
    } else {
      System.out.println(Thread.currentThread().getName() + " read close ");
    }
  }

  private void reset() {
    this._a = 0;
    this.flag = false;
  }

}
