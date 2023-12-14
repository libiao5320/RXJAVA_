package com.lee.test;

import rx.Observable;
import rx.Observer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 作者： 李彪
 * 日期： 2023/6/28
 * 描述：
 **/
public class Test {




    public static void main(String[] args) {
        try {
            final CountDownLatch latch = new CountDownLatch(9);
            ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 100, 5000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
            for (int i = 0; i < 10; i++) {
                A a = new A(latch);

                executorService.submit(a);
            }
            latch.await();
            System.out.println("所有线程都已经跑完");
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    static class A implements Runnable {

        private CountDownLatch countDownLatch ;
        A(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName() +" 开始工作");



                Observable observable =                 Observable.range(1,100);
            observable.subscribe(new Observer() {
                @Override
                public void onCompleted() {
                    System.out.println(Thread.currentThread().getName()+"完成");
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Object o) {

                    System.out.println(Thread.currentThread().getName() + "计数 : " + o);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
            });

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown();
        }
    }
}
