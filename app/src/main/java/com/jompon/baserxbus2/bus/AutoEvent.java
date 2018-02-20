package com.jompon.baserxbus2.bus;

/**
 * Created by Jompon on 1/17/2018.
 */

public class AutoEvent {

    private String name;
    public AutoEvent( )
    {
        this("AutoEvent");
    }

    public AutoEvent(String name)
    {
        this.name = name;
    }

    public String getName( )
    {
        return name;
    }
}
