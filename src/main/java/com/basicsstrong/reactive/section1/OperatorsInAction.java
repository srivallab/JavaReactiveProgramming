package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.Comparator;
import java.util.List;

public class OperatorsInAction {

    public static void main(String[] args) {
        Observable<Employee> employee = Observable.just(
                new Employee(1, "a", 10000, 4),
                new Employee(2, "b", 11000, 3),
                new Employee(3, "c", 12000, 5),
                new Employee(4, "d", 13000, 5)
        );

        employee
                .filter(e -> e.getRating() < 5)
                .sorted(Comparator.comparingDouble(Employee::getRating))
                .map(e -> e.getName())
                .take(3)
//                .toList()
                .subscribe(System.out::println);


        List<Integer> expenses = List.of(200, 133, 7697, 7218, 2810, 12891, 19810, 29181, 4535);

        Observable.fromIterable(expenses)
                .scan((a,b) -> a + b)
                .reduce((a,b) -> a + b)
                .subscribe(System.out::println);


    }
}
