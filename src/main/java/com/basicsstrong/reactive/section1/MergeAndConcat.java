package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

import java.util.concurrent.TimeUnit;

public class MergeAndConcat {


    public static void main(String[] args) throws InterruptedException {
//        Observable<String> src1 = Observable.just("Hi", "Hello", "Welcome");
//        Observable<String> src2 = Observable.just("Hii", "Helloo", "Welcomee");

        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "SRC" + e);

        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "SRC" + e);


//        Observable.concat(src1, src2)
//                .subscribe(e -> System.out.println(e));
//
//        src1.concatWith(src2)
//                .subscribe(e -> System.out.println(e));

        Thread.sleep(10000);

        Observable<Integer> observable = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(10);
                emitter.onNext(20);
                emitter.onComplete();
            }
        });

        observable.subscribe( e -> System.out.println("Observer 1 :" + e));
    }
}
