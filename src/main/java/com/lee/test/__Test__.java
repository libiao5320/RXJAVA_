package com.lee.test;

import rx.Observable;
import rx.Observer;
import rx.functions.Func0;

/**
 * @author
 * @create 2018-03-15 14:19
 **/
public class __Test__<T> {

  private Observable<T> observable = null;
  private Observer observer = null;


  public Observable<T> create() {
    observable = Observable.defer(new Func0<Observable<T>>() {
      public Observable<T> call() {
        return null;
      }
    });
    return observable;
  }

}
