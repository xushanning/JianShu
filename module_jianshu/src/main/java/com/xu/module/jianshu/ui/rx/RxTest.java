package com.xu.module.jianshu.ui.rx;

import androidx.annotation.NonNull;

public class RxTest {
    void test() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) {
                emitter.onNext("xu");
                emitter.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
