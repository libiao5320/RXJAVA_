package com.lee.rx;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.observables.BlockingObservable;
import rx.observers.Observers;
import rx.observers.TestObserver;

import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class TestRxObserver {

        public static void main(String [] args) {
                Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6, 7);
                BlockingObservable blockingObservable = BlockingObservable.from(observable);
                Subscription subscription  = observable.subscribe(Observers.create(t -> {
                        t = t + 5;
                        System.out.println(t);
                }));
                observable.lift(new Observable.Operator<Object, Integer>() {
                        @Override
                        public Subscriber<? super Integer> call(Subscriber<? super Object> subscriber) {
                                return new Subscriber<Integer>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {

                                        }

                                        @Override
                                        public void onNext(Integer integer) {
                                                Integer _integer = integer + 8;
                                                System.out.println("_integer" +_integer);
                                        }
                                };
                        }
                }).subscribe();
                System.out.println(blockingObservable.first());
        }
}
