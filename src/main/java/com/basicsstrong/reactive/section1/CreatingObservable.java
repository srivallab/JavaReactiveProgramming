package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class CreatingObservable {

    public static void main(String[] args) {
        @NonNull Observable<Object> source = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(12);
                    e.onComplete();
                }
        );

        source.subscribe(System.out::println);


        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        just.subscribe(System.out::println);


        //from Interable
        List<String> myList = List.of("rxjava1", "rxjava2", "rxjava3", "rxjava4", "rxjava5");

        Observable<String> fromIter = Observable.fromIterable(myList);

        fromIter.subscribe(System.out::println);
    }
}

