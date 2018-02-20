package com.jompon.baserxbus2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jompon.baserxbus2.R;
import com.jompon.baserxbus2.bus.TapEvent;
import com.jompon.baserxbus2.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, new MainFragment());
        ft.commit();

        ((Button)findViewById(R.id.btn_location)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void tapEvent(TapEvent event) {
        ((TextView)findViewById(R.id.txt)).setText(event.getName());
    }
}
