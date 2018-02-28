/*
 * Copyright (C) 2018 jompons.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jompon.baserxbus2.activity;

import android.support.v7.app.AppCompatActivity;

import com.jompon.baserxbus2.bus.AutoEvent;
import com.jompon.baserxbus2.bus.RxBusProvider;
import com.jompon.baserxbus2.bus.TapEvent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
