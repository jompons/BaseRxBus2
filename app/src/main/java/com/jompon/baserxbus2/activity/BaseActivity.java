package com.jompon.baserxbus2.activity;

import android.support.v7.app.AppCompatActivity;

import com.jompon.baserxbus2.bus.AutoEvent;
import com.jompon.baserxbus2.bus.RxBusProvider;
import com.jompon.baserxbus2.bus.TapEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jompon on 1/17/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private final CompositeDisposable disposables = new CompositeDisposable();

    private void addRxBus( ){

        disposables.add(RxBusProvider.getInstance()
                .getRxBus()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object object) throws Exception {

                        if( object instanceof AutoEvent ){
                            autoEvent((AutoEvent) object);
                        }
                        if( object instanceof TapEvent ){
                            tapEvent((TapEvent) object);
                        }
                    }
                }));
    }

    private void removeRxBus( ){

        disposables.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addRxBus();
    }

    @Override
    protected void onPause() {
        removeRxBus();
        super.onPause();
    }

    protected void autoEvent(AutoEvent event){}
    protected void tapEvent(TapEvent event){}
}
