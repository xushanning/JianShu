package com.xu.module.jianshu.ui.rx;

import androidx.annotation.NonNull;

public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull ObservableEmitter<T> emitter);
}
