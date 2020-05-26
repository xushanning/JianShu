package com.xu.module.jianshu.ui.rx;


/**
 * @author 许
 */
public interface ObservableEmitter<T> {
    void onNext(T value);

    void onComplete();
}
