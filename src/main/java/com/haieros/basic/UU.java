package com.haieros.basic;


import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author DELL
 * @time 2017-08-03 17:41
 **/

public class UU {


    public static void main(String[] args) {

        Observable.just(1, 1, 1, 3, 4, 3, 5)
                .distinct() //distinct 去重
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                        System.out.println("distinct:" + integer);
                    }
                });

        Observable.just(1, 30, 4, 23)
                .filter(new Predicate<Integer>() { //过滤
                    @Override
                    public boolean test(Integer integer) throws Exception {

                        return integer >= 10;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("accept:" + integer);
            }
        });
    }
}
