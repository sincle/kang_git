package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * reduce 操作符每次用一个方法处理一个值,可以有一个seed作为初始值
 * @author DELL
 * @time 2017-08-04 14:07
 **/

public class FF {


    public static void main(String[] args){

        Observable.just(1,2,3)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer+integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("reduce:"+integer);
            }
        });
    }
}
