package com.xu.module.jianshu.ui.rx;

import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * 关于RxPlugins hook的用法
 *
 * @author 许
 */
public class RxPlugins {
    public void insert() {
        RxJavaPlugins.reset();
        RxJavaPlugins.setOnObservableSubscribe(new BiFunction<Observable, Observer, Observer>() {
            @Override
            public Observer apply(Observable observable, Observer observer) throws Exception {
                return new MyObserver(observer);
            }
        });

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("xu");
                emitter.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Logger.d("real onNext");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Logger.d("real onComplete");
            }
        });

    }

    private class MyObserver<T> implements Observer<T> {
        private Observer<T> real;

        public MyObserver(Observer<T> real) {
            this.real = real;
        }

        @Override
        public void onSubscribe(Disposable d) {
            real.onSubscribe(d);
        }


        @Override
        public void onNext(T o) {
            Logger.d("before onNext");
            real.onNext(o);
            Logger.d("after onNext");
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            Logger.d("before onComplete");
            real.onComplete();
            Logger.d("after onComplete");
        }
    }
}
