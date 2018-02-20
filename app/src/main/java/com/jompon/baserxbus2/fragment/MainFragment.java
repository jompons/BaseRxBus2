package com.jompon.baserxbus2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jompon.baserxbus2.R;
import com.jompon.baserxbus2.bus.RxBusProvider;
import com.jompon.baserxbus2.bus.TapEvent;

/**
 * Created by Jompon on 1/17/2018.
 */

public class MainFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        ((Button) view.findViewById(R.id.btn_send)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TapEvent tapEvent = new TapEvent("TAP!!");
                RxBusProvider
                        .getInstance()
                        .getRxBus()
                        .send(tapEvent);
            }
        });
        return view;
    }
}
