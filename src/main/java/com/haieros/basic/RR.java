package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * concat
 * 对于单一的把两个发射器连接成一个发射器，虽然 zip 不能完成，
 * 但我们还是可以自力更生，官方提供的 concat 让我们的问题得到
 * 了完美解决。
 * @author DELL
 * @create 2017-08-03 10:49
 **/

public class RR {


    /**
     * 可以看到。发射器 B 把自己的三个孩子送给了发射器 A，让他们组
     * 合成了一个新的发射器，非常懂事的孩子，有条不紊的排序接收。
     * @param args
     */
    public static void main(String[] args){
        //todo

        Observable.concat(Observable.just(4,5,6)
                ,Observable.just(1,2,3))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("result:"+integer);
                    }
                });
    }
}
