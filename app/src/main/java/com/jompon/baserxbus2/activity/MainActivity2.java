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

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jompon.baserxbus2.R;
import com.jompon.baserxbus2.bus.AutoEvent;
import com.jompon.baserxbus2.service.FusedLocationService;

public class MainActivity2 extends BaseActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bindingView();
        startFusedLocationService();
    }

    private void bindingView( )
    {
        txt = (TextView) findViewById(R.id.txt);
    }

    @Override
    protected void onDestroy() {
        stopFusedLocationService();
        super.onDestroy();
    }

    @Override
    protected void autoEvent(AutoEvent event) {
        txt.setText(event.getName());
    }

    private void startFusedLocationService( )
    {
        Intent intent = new Intent(this, FusedLocationService.class);
        intent.setAction(FusedLocationService.START_ACTION);
        startService(intent);
    }

    private void stopFusedLocationService( )
    {
        Intent intent = new Intent(this, FusedLocationService.class);
        intent.setAction(FusedLocationService.STOP_ACTION);
        stopService(intent);
    }
}
