package com.lee.test;

import rx.Observable;
import rx.Observer;
import rx.functions.Func0;


public class __Test__<T> {

  private Observable<T> observable = null;
  private Observer observer = null;


  /**
   * <p>create.</p>
   *
   * @return a {@link rx.Observable} object.
   */
  public Observable<T> create() {
    observable = Observable.defer(new Func0<Observable<T>>() {
      public Observable<T> call() {
        return null;
      }
    });
    return observable;
  }

}
