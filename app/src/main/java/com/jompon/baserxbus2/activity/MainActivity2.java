package com.jompon.baserxbus2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jompon.baserxbus2.R;
import com.jompon.baserxbus2.bus.AutoEvent;
import com.jompon.baserxbus2.service.FusedLocationService;

/**
 * Created by Jompon on 1/17/2018.
 */

public class MainActivity2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        startFusedLocationService();
    }

    @Override
    protected void onDestroy() {
        stopFusedLocationService();
        super.onDestroy();
    }

    @Override
    protected void autoEvent(AutoEvent event) {
        ((TextView)findViewById(R.id.txt)).setText(event.getName());
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
