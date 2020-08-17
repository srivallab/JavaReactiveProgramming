package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

public class Operators {

    public static void main(String[] args) {
        Observable.just(45, 78, 90, 37, 80, 12, 100, 78, 76)
                .filter(e -> (e < 75))
                .sorted()
                .distinct()
                .subscribe(e -> System.out.println(e));
    }



}
