package com.lee.rx;

import rx.Notification;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.observables.BlockingObservable;
import rx.observables.ConnectableObservable;
import rx.schedulers.NewThreadScheduler;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;


public class TestObserver {

    public static void main(String[] args) {


        Observer observer = new Observer<Command>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Command command) {
                command.execute();
            }
        };

        NewThreadScheduler newThreadScheduler = (NewThreadScheduler) Schedulers.newThread();


        Notification commandNotification = Notification.createOnNext(new Command());
        Observable observable =  Observable.just(commandNotification.getValue());
        observable = observable.subscribeOn(newThreadScheduler);

        ConnectableObservable connectableObservable = observable.replay();
        connectableObservable.subscribe(observer);
//        connectableObservable.connect((t)->{
//            System.out.println("1111111111111");
//        });

        BlockingObservable<Command> blockingObservable = BlockingObservable.from(connectableObservable);
//        blockingObservable.forEach(t->{
//            t.execute();
//        });

//        observable.subscribe(observer);

//        newThreadScheduler.now();
//        NewThreadWorker threadWork = (NewThreadWorker) newThreadScheduler.createWorker();
////        threadWork.scheduleActual(()->{System.out.println("threadWork执行");},1,TimeUnit.SECONDS);
//        threadWork.scheduleActual(()->{
//            observable.subscribe(observer);
//        },5,TimeUnit.SECONDS);


        Scheduler testScheduler = Schedulers.immediate();
        Scheduler.Worker worker = testScheduler.createWorker();
        worker.schedulePeriodically(()->{
            System.out.println("work执行");
        },1,10,TimeUnit.SECONDS);


        try {
            Thread.currentThread().join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        testScheduler.advanceTimeBy(5000, TimeUnit.HOURS);
    }

    static class Command {
        public void execute() {
            System.out.println("命令开始执行");
        }
    }
}
