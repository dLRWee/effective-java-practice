package com.smarthome.core;

import java.util.Collections;
import java.util.List;

public class SmartController 
{
    private static final String[] SUPPORTED_MODES_PRIVATE = {"ECO", "TURBO"};
    public static final List<String> SUPPORTED_MODES = List.of(SUPPORTED_MODES_PRIVATE);
    
    private final int batteryLevel;

    public SmartController(int batteryLevel)
    {
        this.batteryLevel = batteryLevel;
    }

    protected void pulseCheck()
    {
        System.out.println("Checking pulse...");
        System.out.println("It's alright!");
    }

    public String getStatus()
    {
        return String.format("Battery level: %s", this.batteryLevel);
    }
}