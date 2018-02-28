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
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jompon.baserxbus2.R;
import com.jompon.baserxbus2.bus.TapEvent;
import com.jompon.baserxbus2.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    private Button btnLocation;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindingView();
        bindingData();
        if( savedInstanceState == null ){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, new MainFragment());
            ft.commit();
        }
    }

    private void bindingView( )
    {
        btnLocation = (Button) findViewById(R.id.btn_location);
        txt = (TextView) findViewById(R.id.txt);
    }

    private void bindingData( )
    {
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void tapEvent(TapEvent event) {
        txt.setText(event.getName());
    }
}
