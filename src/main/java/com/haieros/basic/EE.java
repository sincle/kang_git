package com.haieros.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * zip 专用于合并事件，该合并不是连接（连接操作符后面会说），
 * 而是两两配对，
 * 也就意味着，最终配对出的 Observable 发射事件数目只和少的那个相同。
 *
 * @author DELL
 * @create 2017-08-03 10:31
 **/

public class EE {


    /**
     * zip 组合事件的过程就是分别从发射器 A 和发射器 B 各取出一个事件来组合，
     * 并且一个事件只能被使用一次，组合的顺序是严格按照事件发送的顺序来进行的，
     * 所以上面截图中，可以看到，1 永远是和 A 结合的，2 永远是和 B 结合的。
     *
     * 最终接收器收到的事件数量是和发送器发送事件最少的那个发送器的发送事件数目相同，
     * 所以如截图中，5 很孤单，没有人愿意和它交往，孤独终老的单身狗。
     * @param args
     */
    public static void main(String[] args) {
        //todo

        Observable.zip(getIntergerObservable(), getStringObservable(),new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer,String s) throws Exception {
                return s + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("accept:" + s);
            }
        });
    }

    private static Observable<Integer> getIntergerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                System.out.println("emit 1 \n");
                e.onNext(2);
                System.out.println("emit 2 \n");
                e.onNext(3);
                System.out.println("emit 3 \n");
                e.onNext(4);
                System.out.println("emit 4 \n");
                e.onNext(5);
                System.out.println("emit 5 \n");
            }
        });
    }

    private static Observable<String> getStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("a");
                System.out.println("emit a \n");
                e.onNext("b");
                System.out.println("emit b\n");
                e.onNext("c");
                System.out.println("emit c\n");
                e.onNext("d");
                System.out.println("emit d\n");
            }
        });
    }
}
