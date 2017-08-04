package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * interval 操作符用于间隔时间执行某个操作，其接受三个参数，
 * 分别是第一次发送延迟，间隔时间，时间单位
 * @author DELL
 * @time 2017-08-04 9:36
 **/


public class II {


    public static void main(String[] args){

        Disposable subscribe = Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        System.out.println("interval:" + aLong + "at:" + new Date().toString());
                    }

                });

        Observable.just(1,2,3,4)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("doOnNext 保存"+integer+"成功"+"\n");
                    }
                })
                .subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

                System.out.println("doOnNext:"+integer+"" + "\n");
            }
        });

        Observable.just(1,2,3,4,5)
                .skip(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("skip:"+integer+"\n");
                    }
                });
    }
}
