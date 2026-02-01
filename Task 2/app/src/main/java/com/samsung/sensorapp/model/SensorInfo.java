package com.samsung.sensorapp.model;

import android.hardware.Sensor;

/**
 * Model class representing sensor metadata information
 */
public class SensorInfo {
    private Sensor sensor;
    private boolean isAvailable;
    private String description;

    public SensorInfo(Sensor sensor, boolean isAvailable, String description) {
        this.sensor = sensor;
        this.isAvailable = isAvailable;
        this.description = description;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return sensor != null ? sensor.getName() : "Unknown";
    }

    public String getType() {
        return sensor != null ? sensor.getStringType() : "Unknown";
    }

    public float getMaximumRange() {
        return sensor != null ? sensor.getMaximumRange() : 0;
    }

    public float getPower() {
        return sensor != null ? sensor.getPower() : 0;
    }

    public int getMinDelay() {
        return sensor != null ? sensor.getMinDelay() : 0;
    }

    public int getMaxDelay() {
        return sensor != null ? sensor.getMaxDelay() : 0;
    }

    public String getVendor() {
        return sensor != null ? sensor.getVendor() : "Unknown";
    }

    public float getResolution() {
        return sensor != null ? sensor.getResolution() : 0;
    }

    public int getVersion() {
        return sensor != null ? sensor.getVersion() : 0;
    }
}
