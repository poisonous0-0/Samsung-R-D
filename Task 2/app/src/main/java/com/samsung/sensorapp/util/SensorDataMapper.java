package com.samsung.sensorapp.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

import com.samsung.sensorapp.model.SensorData;

/**
 * Utility class to map Android SensorEvent to SensorData model
 */
public class SensorDataMapper {

    /**
     * Map SensorEvent to SensorData model
     */
    public static SensorData mapToSensorData(SensorEvent event) {
        String unit = getSensorUnit(event.sensor.getType());
        return new SensorData(
                event.sensor.getName(),
                event.sensor.getType(),
                event.values.clone(),
                event.accuracy,
                event.timestamp,
                unit
        );
    }

    /**
     * Get the unit of measurement for a sensor type
     */
    private static String getSensorUnit(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return "m/s²";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "µT";
            case Sensor.TYPE_GYROSCOPE:
                return "rad/s";
            case Sensor.TYPE_LIGHT:
                return "lx";
            case Sensor.TYPE_PRESSURE:
                return "hPa";
            case Sensor.TYPE_TEMPERATURE:
                return "°C";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return "%";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return "°C";
            case Sensor.TYPE_STEP_COUNTER:
                return "steps";
            case Sensor.TYPE_STEP_DETECTOR:
                return "event";
            case Sensor.TYPE_PROXIMITY:
                return "cm";
            default:
                return "unit";
        }
    }

    /**
     * Get readable name for sensor type
     */
    public static String getSensorTypeName(int sensorType) {
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return "Accelerometer";
            case Sensor.TYPE_MAGNETIC_FIELD:
                return "Magnetometer";
            case Sensor.TYPE_GYROSCOPE:
                return "Gyroscope";
            case Sensor.TYPE_LIGHT:
                return "Light Sensor";
            case Sensor.TYPE_PRESSURE:
                return "Barometer";
            case Sensor.TYPE_TEMPERATURE:
                return "Temperature";
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return "Humidity";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return "Ambient Temperature";
            case Sensor.TYPE_STEP_COUNTER:
                return "Step Counter";
            case Sensor.TYPE_STEP_DETECTOR:
                return "Step Detector";
            case Sensor.TYPE_PROXIMITY:
                return "Proximity Sensor";
            case Sensor.TYPE_GRAVITY:
                return "Gravity";
            case Sensor.TYPE_LINEAR_ACCELERATION:
                return "Linear Acceleration";
            case Sensor.TYPE_ROTATION_VECTOR:
                return "Rotation Vector";
            default:
                return "Unknown Sensor";
        }
    }

    /**
     * Get sensor data description based on values
     */
    public static String getSensorDescription(int sensorType, float[] values) {
        if (values == null || values.length == 0) {
            return "No data available";
        }

        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                return String.format("X: %.2f, Y: %.2f, Z: %.2f m/s²", values[0], values[1], values[2]);
            case Sensor.TYPE_MAGNETIC_FIELD:
                return String.format("X: %.2f, Y: %.2f, Z: %.2f µT", values[0], values[1], values[2]);
            case Sensor.TYPE_GYROSCOPE:
                return String.format("X: %.2f, Y: %.2f, Z: %.2f rad/s", values[0], values[1], values[2]);
            case Sensor.TYPE_LIGHT:
                return String.format("Light: %.2f lx", values[0]);
            case Sensor.TYPE_PRESSURE:
                return String.format("Pressure: %.2f hPa", values[0]);
            case Sensor.TYPE_TEMPERATURE:
                return String.format("Temperature: %.2f °C", values[0]);
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                return String.format("Humidity: %.2f %%", values[0]);
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return String.format("Ambient Temp: %.2f °C", values[0]);
            case Sensor.TYPE_STEP_COUNTER:
                return String.format("Steps: %.0f", values[0]);
            case Sensor.TYPE_PROXIMITY:
                return String.format("Distance: %.2f cm", values[0]);
            default:
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < values.length; i++) {
                    sb.append(String.format("%.2f", values[i]));
                    if (i < values.length - 1) sb.append(", ");
                }
                return sb.toString();
        }
    }
}
