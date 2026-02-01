package com.samsung.sensorapp.manager;

import com.samsung.sensorapp.model.SensorData;

/**
 * Interface for listening to sensor data changes
 * Implementers will receive callbacks when sensor data is updated
 */
public interface SensorEventListener {
    /**
     * Called when sensor data is updated
     */
    void onSensorDataChanged(SensorData sensorData);

    /**
     * Called when sensor accuracy changes
     */
    void onSensorAccuracyChanged(int accuracy);

    /**
     * Called when there's an error reading sensor data
     */
    void onSensorError(String errorMessage);
}
