package com.xu.module.jianshu.ui.rx;

/**
 * @author 许
 * 注意这里的observable泛型变成R了
 */
public class ObservableMap<T, R> extends Observable<R> {
    private Function<? super T, ? extends R> function;
    private ObservableSource<T> source;

    public ObservableMap(ObservableSource<T> source, Function<? super T, ? extends R> function) {
        this.function = function;
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<? super R> observer) {
        source.subscribe(new MapObserver<T, R>(function, observer));
    }

    static class MapObserver<T, R> implements Observer<T> {
        final Function<? super T, ? extends R> mapper;
        final Observer<? super R> actual;

        //actual为最终的订阅的observer
        public MapObserver(Function<? super T, ? extends R> mapper, Observer<? super R> actual) {
            this.mapper = mapper;
            this.actual = actual;
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            R r = mapper.apply(t);
            actual.onNext(r);
        }

        @Override
        public void onComplete() {
            actual.onComplete();
        }
    }
}
