package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

public class Grouping {

    public static void main(String[] args) {
        Observable<Employee> obs = Observable.just(
                new Employee(1, "Amma", 100000000, 100),
                new Employee(2, "Nanna", 100000000, 100),
                new Employee( 3, "Chelli", 100000000, 10),
                new Employee(4, "Ammamma", 100000000, 10)
        );

        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), val -> val.getName()));

        System.out.println("Number of cores : " + Runtime.getRuntime().availableProcessors());
    }
}
