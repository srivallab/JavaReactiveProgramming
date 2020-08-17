package com.basicsstrong.reactive.section1;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class ColdObservables {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();

        myList.add(13);
        myList.add(14);
        myList.add(15);

        Observable<Integer> source = Observable.fromIterable(myList);



        myList = getData(myList);

        source.subscribe(System.out::println);
    }


    private static List<Integer> getData(List<Integer> list){
        list.add(53);
        return list;
    }

}
