package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.Callable;

/**
 * defer
 * 每次订阅都会创建一个新的 Observable，
 * 并且如果没有被订阅，就不会产生新的 Observable
 * @author DELL
 * @time 2017-08-04 11:08
 **/

public class DD {


    public static void main(String[] args){

        Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                return Observable.just(1, 2, 3);
            }
        });

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

                System.out.println("defer:"+integer);
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("defer:onError"+e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
