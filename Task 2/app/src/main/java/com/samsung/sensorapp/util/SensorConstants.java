package com.samsung.sensorapp.util;

import android.hardware.Sensor;

/**
 * Constants for sensor types and sampling rates
 */
public class SensorConstants {
    // Sampling rates
    public static final int SAMPLING_RATE_FASTEST = SensorManager.SENSOR_DELAY_FASTEST;
    public static final int SAMPLING_RATE_GAME = SensorManager.SENSOR_DELAY_GAME;
    public static final int SAMPLING_RATE_UI = SensorManager.SENSOR_DELAY_UI;
    public static final int SAMPLING_RATE_NORMAL = SensorManager.SENSOR_DELAY_NORMAL;

    // Default sampling rate
    public static final int DEFAULT_SAMPLING_RATE = SAMPLING_RATE_NORMAL;

    // Common sensor types to monitor
    public static final int[] COMMON_SENSOR_TYPES = {
            Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_MAGNETIC_FIELD,
            Sensor.TYPE_GYROSCOPE,
            Sensor.TYPE_LIGHT,
            Sensor.TYPE_PRESSURE,
            Sensor.TYPE_AMBIENT_TEMPERATURE,
            Sensor.TYPE_RELATIVE_HUMIDITY,
            Sensor.TYPE_PROXIMITY,
            Sensor.TYPE_GRAVITY,
            Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_ROTATION_VECTOR,
            Sensor.TYPE_STEP_COUNTER,
            Sensor.TYPE_STEP_DETECTOR
    };

    // Permission constants
    public static final String[] REQUIRED_PERMISSIONS = {
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.BODY_SENSORS"
    };
}

// Note: SensorManager import needs to be handled - define it properly
abstract class SensorManager {
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_UI = 2;
    public static final int SENSOR_DELAY_NORMAL = 3;
}
