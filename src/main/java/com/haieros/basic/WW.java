package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * map基本作用就是将一个 Observable 通过某种函数关系，
 * 转换为另一种 Observable，
 * 上面例子中就是把我们的 Integer 数据变成了 String 类型。
 * @author DELL
 * @create 2017-08-03 10:26
 **/

public class WW {


    public static void main(String[] args){
        //todo
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {

                return "This is result " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                 System.out.println("accept:"+s+"\n");
            }
        });
    }
}
