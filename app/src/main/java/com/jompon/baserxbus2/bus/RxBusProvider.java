package com.jompon.baserxbus2.bus;

/**
 * Created by Jompon on 1/17/2018.
 */

public class RxBusProvider {

    private static RxBusProvider rxBusProvider;
    private RxBus rxBus;
    private RxBusProvider()
    {
        rxBus = new RxBus();
    }

    public synchronized static RxBusProvider getInstance( )
    {
        if( rxBusProvider == null ) rxBusProvider = new RxBusProvider();
        return rxBusProvider;
    }

    public RxBus getRxBus( )
    {
        return rxBus;
    }
}
