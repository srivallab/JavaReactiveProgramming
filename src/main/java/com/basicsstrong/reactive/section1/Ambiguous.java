package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Ambiguous {
    public static void main(String[] args) throws InterruptedException {
//        Observable <Long> ob1 = Observable.interval(1, TimeUnit.SECONDS);
//        Observable <Long> ob1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable <Long> ob1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10)
                .map(e -> e);
        Observable <Long> ob2 = Observable.interval(1, TimeUnit.SECONDS).take(10)
                .map(e -> e);
//gets the fastest thread
//        Observable.amb(Arrays.asList(ob1, ob2))
//                .subscribe(System.out::println);


        Observable.zip(ob1, ob2, (e1, e2) -> "Haha 1"+ e1 +"haha 2"+e2)
                .subscribe(e -> System.out.println(e));

        Thread.sleep(11000);
    }
}
