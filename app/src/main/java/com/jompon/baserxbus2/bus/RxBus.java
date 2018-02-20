package com.jompon.baserxbus2.bus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Jompon on 1/17/2018.
 */

public class RxBus {

    public RxBus() {
    }

    private PublishSubject<Object> bus = PublishSubject.create();

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
