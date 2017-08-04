package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author DELL
 * @time 2017-08-04 9:43
 **/

public class PP {

    public static void main(String[] args){

        Observable.just(1,2,3,4,5).buffer(3,2)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {

                        System.out.println("buffer size :"+integers.size());
                        System.out.println("buffer value");
                        for (Integer i : integers) {

                            System.out.println("i:"+i);
                        }
                    }
                });

        System.out.println("-----------------------------------------------");

        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("timer:"+aLong+"at:"+new Date().toString());                    }
                });

        System.out.println("-----------------------------------------------");
    }
}


























