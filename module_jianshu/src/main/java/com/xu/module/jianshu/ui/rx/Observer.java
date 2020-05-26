package com.xu.module.jianshu.ui.rx;

import io.reactivex.annotations.NonNull;

/**
 * @author 许
 */
public interface Observer<T> {
    void onSubscribe();

    void onNext(@NonNull T t);

    void onComplete();
}
