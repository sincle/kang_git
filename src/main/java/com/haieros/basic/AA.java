package com.haieros.basic;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * take ，接受一个 long 型参数 count ，代表至多接收 count 个数据。
 * @author DELL
 * @time 2017-08-04 10:17
 **/

public class AA {


    public static void main(String[] args){

        Flowable.fromArray(1,2,3,4,5)
                .take(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("accept take:"+integer+"\n");
                    }
                });

        
    }
}
