package com.samsung.sensorapp.manager;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.samsung.sensorapp.model.SensorData;
import com.samsung.sensorapp.util.SensorDataMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SensorManager wrapper to handle sensor data reading and management
 * This class abstracts Android's native SensorManager and provides
 * a cleaner interface for sensor data acquisition
 */
public class SensorDataManager {
    private static final String TAG = "SensorDataManager";

    private final Context context;
    private final SensorManager sensorManager;
    private final Map<Integer, List<com.samsung.sensorapp.manager.SensorEventListener>> listenerMap;
    private final Map<Integer, SensorEventListenerImpl> sensorListenerMap;

    public SensorDataManager(Context context) {
        this.context = context;
        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        this.listenerMap = new HashMap<>();
        this.sensorListenerMap = new HashMap<>();
    }

    /**
     * Register a listener for a specific sensor
     */
    public void registerListener(int sensorType, com.samsung.sensorapp.manager.SensorEventListener listener, int samplingPeriodUs) {
        if (sensorManager == null) {
            Log.e(TAG, "SensorManager is not available");
            return;
        }

        Sensor sensor = sensorManager.getDefaultSensor(sensorType);
        if (sensor == null) {
            Log.e(TAG, "Sensor type " + sensorType + " is not available");
            if (listener != null) {
                listener.onSensorError("Sensor type " + sensorType + " is not available on this device");
            }
            return;
        }

        // Add listener to the map
        if (!listenerMap.containsKey(sensorType)) {
            listenerMap.put(sensorType, new ArrayList<>());
        }
        listenerMap.get(sensorType).add(listener);

        // Create and register the internal listener
        if (!sensorListenerMap.containsKey(sensorType)) {
            SensorEventListenerImpl internalListener = new SensorEventListenerImpl(sensorType);
            sensorListenerMap.put(sensorType, internalListener);
            sensorManager.registerListener(internalListener, sensor, samplingPeriodUs);
            Log.d(TAG, "Listener registered for sensor: " + sensor.getName());
        }
    }

    /**
     * Unregister a listener for a specific sensor
     */
    public void unregisterListener(int sensorType, com.samsung.sensorapp.manager.SensorEventListener listener) {
        if (listenerMap.containsKey(sensorType)) {
            List<com.samsung.sensorapp.manager.SensorEventListener> listeners = listenerMap.get(sensorType);
            listeners.remove(listener);

            // If no more listeners, unregister from SensorManager
            if (listeners.isEmpty()) {
                listenerMap.remove(sensorType);
                SensorEventListenerImpl internalListener = sensorListenerMap.remove(sensorType);
                if (internalListener != null && sensorManager != null) {
                    sensorManager.unregisterListener(internalListener);
                    Log.d(TAG, "Listener unregistered for sensor type: " + sensorType);
                }
            }
        }
    }

    /**
     * Unregister all listeners for a specific sensor
     */
    public void unregisterAllListeners(int sensorType) {
        if (listenerMap.containsKey(sensorType)) {
            listenerMap.remove(sensorType);
            SensorEventListenerImpl internalListener = sensorListenerMap.remove(sensorType);
            if (internalListener != null && sensorManager != null) {
                sensorManager.unregisterListener(internalListener);
            }
        }
    }

    /**
     * Unregister all listeners
     */
    public void unregisterAllListeners() {
        for (int sensorType : new ArrayList<>(sensorListenerMap.keySet())) {
            unregisterAllListeners(sensorType);
        }
    }

    /**
     * Get a list of all available sensors
     */
    public List<Sensor> getAvailableSensors() {
        if (sensorManager == null) {
            return new ArrayList<>();
        }
        return sensorManager.getSensorList(Sensor.TYPE_ALL);
    }

    /**
     * Get a specific sensor
     */
    public Sensor getSensor(int sensorType) {
        if (sensorManager == null) {
            return null;
        }
        return sensorManager.getDefaultSensor(sensorType);
    }

    /**
     * Check if a sensor type is available on the device
     */
    public boolean isSensorAvailable(int sensorType) {
        return getSensor(sensorType) != null;
    }

    /**
     * Internal implementation of SensorEventListener
     */
    private class SensorEventListenerImpl implements SensorEventListener {
        private final int sensorType;

        SensorEventListenerImpl(int sensorType) {
            this.sensorType = sensorType;
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            SensorData sensorData = SensorDataMapper.mapToSensorData(event);
            
            // Notify all registered listeners
            if (listenerMap.containsKey(sensorType)) {
                List<com.samsung.sensorapp.manager.SensorEventListener> listeners = listenerMap.get(sensorType);
                for (com.samsung.sensorapp.manager.SensorEventListener listener : listeners) {
                    try {
                        listener.onSensorDataChanged(sensorData);
                    } catch (Exception e) {
                        Log.e(TAG, "Error notifying listener", e);
                    }
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            if (listenerMap.containsKey(sensorType)) {
                List<com.samsung.sensorapp.manager.SensorEventListener> listeners = listenerMap.get(sensorType);
                for (com.samsung.sensorapp.manager.SensorEventListener listener : listeners) {
                    try {
                        listener.onSensorAccuracyChanged(accuracy);
                    } catch (Exception e) {
                        Log.e(TAG, "Error notifying accuracy change", e);
                    }
                }
            }
        }
    }
}
