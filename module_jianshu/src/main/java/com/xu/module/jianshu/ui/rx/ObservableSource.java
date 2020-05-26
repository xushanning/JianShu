package com.xu.module.jianshu.ui.rx;

/**
 * @author 许
 */
public interface ObservableSource<T> {

    void subscribe(Observer<? super T> observer);
}
