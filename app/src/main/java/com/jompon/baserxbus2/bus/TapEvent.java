package com.jompon.baserxbus2.bus;

/**
 * Created by Jompon on 1/17/2018.
 */

public class TapEvent {

    private String name;
    public TapEvent( )
    {
        this("TapEvent");
    }

    public TapEvent(String name)
    {
        this.name = name;
    }

    public String getName( )
    {
        return name;
    }
}
