package com.lee.test;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;

import java.util.HashMap;

public class __Test__<T> {

  private static Observable<String> observable = null;



  public static void main(String[] args) {
    observable = create();
    observable= observable.doOnSubscribe(()->{
      System.out.println("被创建");
    });
    observable.doOnNext(r->{
      System.out.println("1");
    });
    observable.doOnNext(r->{
      System.out.println("2");
    });    observable.doOnNext(r->{
      System.out.println("3");
    });
    observable.map((t)->{
      return new HashMap();
    });

    observable.subscribe();

  }


  /**
   * <p>create.</p>
   *
   * @return a {@link rx.Observable} object.
   */
  public static Observable<String> create() {
    observable = Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> subscriber) {

      }
    });
    return observable;
  }

}
