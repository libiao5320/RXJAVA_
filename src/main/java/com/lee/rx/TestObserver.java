package com.lee.rx;

import rx.*;
import rx.internal.schedulers.NewThreadWorker;
import rx.schedulers.ImmediateScheduler;
import rx.schedulers.NewThreadScheduler;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;

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
        Scheduler testScheduler = Schedulers.immediate();

        NewThreadScheduler newThreadScheduler = (NewThreadScheduler) Schedulers.newThread();

        Observable observable =  Observable.just(new Command(), new Command()).subscribeOn(testScheduler);

        observable.subscribe(observer);


        NewThreadWorker threadWork = (NewThreadWorker) newThreadScheduler.createWorker();
        threadWork.scheduleActual(()->{System.out.println("threadWork执行");},1,TimeUnit.SECONDS);


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
