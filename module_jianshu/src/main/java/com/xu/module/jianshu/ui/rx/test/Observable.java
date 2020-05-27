package com.xu.module.jianshu.ui.rx.test;

/**
 * @author 许
 */
public class Observable {
//    private ObservableOnSubscribe subscribe;

//    public Observable(ObservableOnSubscribe subscribe) {
//        this.subscribe = subscribe;
//    }


    void subscribe(ObservableOnSubscribe subscribe,Observer observer) {
        //两种方式
        //方式①
//        CreateEmitter emitter = new CreateEmitter(observer);
//        subscribe.subscribe(emitter);
        //方式②
        subscribe.subscribe(new Emitter() {
            @Override
            public void onNext() {
                observer.onNext();
            }

            @Override
            public void onComplete() {
                observer.onComplete();
            }
        });
    }

    static class CreateEmitter implements Emitter {
        private Observer observer;

        public CreateEmitter(Observer observer) {
            this.observer = observer;
        }

        @Override
        public void onNext() {
            observer.onNext();
        }

        @Override
        public void onComplete() {
            observer.onComplete();
        }
    }
}
