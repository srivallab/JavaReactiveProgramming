package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {

    private static final CompositeDisposable disp = new CompositeDisposable();
    public static void main(String[] args) {

        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);


        Disposable d1  = src.subscribe(e -> System.out.println("Observer 1: " + e));
        Disposable d2  = src.subscribe(e -> System.out.println("Observer 2: " + e));


        try {
            Thread .sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        src.subscribe(e -> System.out.println("Observer 1 :" + e));

        disp.addAll(d1, d2);
        disp.dispose();



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
