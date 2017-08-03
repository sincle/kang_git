package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * flatmap
 * FlatMap 是一个很有趣的东西，我坚信你在实际开发中会经常用到。
 * 它可以把一个发射器 Observable 通过某种方法转换为多个 Observables，
 * 然后再把这些分散的 Observables装进一个单一的发射器 Observable。
 * 但有个需要注意的是，flatMap 并不能保证事件的顺序
 * @author DELL
 * @create 2017-08-03 10:54
 **/

public class TT {


    public static void main(String[] args){
        //todo

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {

                List<String> list = new ArrayList<>();

                for (int i = 0; i < 3; i++) {
                    list.add("i am value "+ integer);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("faltmap accept"+s+"\n");
            }
        });
    }
}
























