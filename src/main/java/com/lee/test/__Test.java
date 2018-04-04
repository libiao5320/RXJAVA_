package com.lee.test;


import java.util.concurrent.CountDownLatch;
import rx.Observable;
import rx.Observer;
import rx.functions.Func0;

/**
 * @author
 * @create 2018-03-15 11:31
 **/
public class __Test<T> {

  private static Observable<?> observable = null;
  private static Observer observer = null;


  public static void main(String[] args) {
    try {
      testRxJavaWithoutBlocking(5);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  public static void testRxJavaWithoutBlocking(int count) throws Exception {
    CountDownLatch finishedLatch = new CountDownLatch(1);
    long t = System.nanoTime();
    Observable.range(0, count).map(i -> {
      //System.out.println("A:" + Thread.currentThread().getName());
      return 200;
    }).subscribe(statusCode -> {
      //System.out.println("B:" + Thread.currentThread().getName());
    }, error -> {
    }, () -> {
      finishedLatch.countDown();
    });
    finishedLatch.await();
    t = (System.nanoTime() - t) / 1000000; //ms
    System.out.println("RxJavaWithoutBlocking TPS: " + count * 1000 / t);
  }

}
