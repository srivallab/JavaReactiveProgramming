package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("item1", "item2", "item3", "item4", "item5")
                .subscribeOn(Schedulers.computation());

        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());

        Thread.sleep(50000);
    }

    public static void compute() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Computation Done By : " + Thread.currentThread().getName());
    }

    public static void Gaytahri(){

    }
}
