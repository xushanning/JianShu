package com.xu.module.jianshu.ui.rx;

import androidx.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

public class RxTest {
    void test() {
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) {
                        emitter.onNext("xu");
                        emitter.onComplete();
                    }
                })
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return 1234;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe() {

                    }

                    @Override
                    public void onNext(Integer s) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        EventBus.getDefault().register(this);
      //  EventBus.getDefault().post();

    }
}
