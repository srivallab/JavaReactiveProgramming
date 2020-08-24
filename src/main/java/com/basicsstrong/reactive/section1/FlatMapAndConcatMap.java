package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatMapAndConcatMap {


    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d","e");
        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);



    }
}