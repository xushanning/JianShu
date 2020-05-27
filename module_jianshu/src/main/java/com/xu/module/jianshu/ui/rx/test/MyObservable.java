package com.xu.module.jianshu.ui.rx.test;

public class MyObservable {
    void test() {
        new Observable().subscribe(new ObservableOnSubscribe() {
            @Override
            public void subscribe(Emitter emitter) {
                emitter.onNext();
                emitter.onComplete();
            }
        }, new Observer() {
            @Override
            public void onNext() {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
