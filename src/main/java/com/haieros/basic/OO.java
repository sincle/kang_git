package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author DELL
 * @create 2017-08-02 18:01
 **/

public class OO {


    public static void main(String[] args) {
        //todo

        Observable.create(new ObservableOnSubscribe<Integer>() {//初始化被观察者
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                System.out.println("Observable emit 1" + "\n");
                e.onNext(1);
                System.out.println("Observable emit 2" + "\n");
                e.onNext(2);
                System.out.println("Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                System.out.println("Observable emit 4" + "\n");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() { //建立与观察者的订阅关系

            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {

                i++;

                if (i == 5) {
                    //在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                }
                System.out.println("result:" + i);
                System.out.println("isDisposable:" + mDisposable.isDisposed());
            }

            @Override
            public void onError(Throwable e) {

                System.out.println("onError:" + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {

                System.out.println("onComplete:" + "\n");
            }
        });
    }
}
