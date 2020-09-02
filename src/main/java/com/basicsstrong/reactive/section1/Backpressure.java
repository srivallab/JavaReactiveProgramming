package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class Backpressure {
    public static void main(String[] args) throws InterruptedException {
        Flowable<Integer> range = Flowable.range(1, 100000);
        range.map(e -> {
            System.out.println("produced item is : " + e + Thread.currentThread().getName());
            return e;
        });
        range.observeOn(Schedulers.io());
        range.subscribe(new Subscriber<Integer>() {

            Subscription s;
            AtomicInteger count = new AtomicInteger(0);


            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                System.out.println("Asking for 20 items: ");
                s.request(20);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("the subscriber consumed " + integer);
                if (count.getAndIncrement() % 20 == 0) {
                    System.out.println("asking for next 20 items ");
                    s.request(20);
                }
                System.out.println("the subscriber consumed : " + integer);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completeddd!");
            }
        });

        Thread.sleep(100000);
    }
}
