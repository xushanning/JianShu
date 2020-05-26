package com.xu.module.jianshu.ui.rx;

/**
 * @author 许
 */
public abstract class Observable<T> implements ObservableSource<T> {
    public static <T> Observable<T> create(ObservableOnSubscribe<T> subscribe) {
        return new ObservableCreate<T>(subscribe);
    }

    @Override
    public void subscribe(Observer<? super T> observer) {
        subscribeActual(observer);
    }


    protected abstract void subscribeActual(Observer<? super T> observer);

//    public <R> Observable<R> map(Function<? super T, ? extends R> mapper) {
//        return
//    }
}
