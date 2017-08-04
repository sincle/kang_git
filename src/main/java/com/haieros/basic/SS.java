package com.haieros.basic;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author DELL
 * @time 2017-08-04 10:43
 **/

public class SS {


    public static void main(String[] args){

        Single.just(new Random().nextInt())
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        System.out.println("interger:"+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError:"+e.getMessage());
                    }
                });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                Thread.sleep(400);
                e.onNext(2);
                Thread.sleep(505);
                e.onNext(3);
                Thread.sleep(100);
                e.onNext(4);
                Thread.sleep(605);
                e.onNext(5);
                Thread.sleep(510);
                e.onComplete();
            }
        }).debounce(500, TimeUnit.MILLISECONDS)//去除小于500的事件
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("integer:"+integer);
                    }
                });
    }
}
