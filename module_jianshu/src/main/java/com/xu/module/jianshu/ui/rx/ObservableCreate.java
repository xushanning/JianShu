package com.xu.module.jianshu.ui.rx;

/**
 * @author 许
 */
public class ObservableCreate<T> extends Observable<T> {
    private ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        CreateEmitter emitter = new CreateEmitter(observer);
        source.subscribe(emitter);
    }

    class CreateEmitter implements ObservableEmitter<T> {
        private Observer<? super T> observer;

        public CreateEmitter(Observer<? super T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T value) {
            observer.onNext(value);
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }

}
