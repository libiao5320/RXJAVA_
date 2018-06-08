package com.lee.test;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;


public class __Test__<T> {

  private static Observable<String> observable = null;
  private Observer observer = null;


  public static void main(String[] args) {

    observable = create();
    observable.doOnSubscribe(() -> {
      System.out.println("aaaaasssss");
    });

    observable.doOnNext(r -> {

      System.out.println("工作");

    });

    Subscription subscription = observable.subscribe((r -> {

      System.out.println("Hello " + r);

    }), (throwable -> {
      System.out.println("Hello " + throwable.getMessage());
    }));

    observable.lift(e -> {
      System.out.println("aaaaa");
      return null;
    });


  }


  /**
   * <p>create.</p>
   *
   * @return a {@link rx.Observable} object.
   */
  public static Observable<String> create() {
//    observable = Observable.defer(new Func0<Observable<T>>() {
//      public Observable<T> call() {
//        return null;
//      }
//    });
//    observer = new Observer() {
//      @Override
//      public void onCompleted() {
//
//      }
//
//      @Override
//      public void onError(Throwable throwable) {
//
//      }
//
//      @Override
//      public void onNext(Object o) {
//
//      }
//    };

    observable = Observable.just("1111");
    observable = Observable.create(e -> {
        System.out.println("bbbbbb");
    });



    return observable;
  }

}
