package com.samsung.sensorapp.model;

/**
 * Model class representing sensor data with timestamp
 * Encapsulates sensor name, type, values, and accuracy information
 */
public class SensorData {
    private String sensorName;
    private int sensorType;
    private float[] values;
    private int accuracy;
    private long timestamp;
    private String unit;

    public SensorData(String sensorName, int sensorType, float[] values, int accuracy, long timestamp, String unit) {
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.values = values;
        this.accuracy = accuracy;
        this.timestamp = timestamp;
        this.unit = unit;
    }

    // Getters
    public String getSensorName() {
        return sensorName;
    }

    public int getSensorType() {
        return sensorType;
    }

    public float[] getValues() {
        return values;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getUnit() {
        return unit;
    }

    /**
     * Get formatted sensor values as a string
     */
    public String getFormattedValues() {
        if (values == null || values.length == 0) {
            return "No data";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(String.format("%.2f", values[i]));
            if (i < values.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    /**
     * Get accuracy level as string representation
     */
    public String getAccuracyString() {
        switch (accuracy) {
            case 0:
                return "Low";
            case 1:
                return "Medium";
            case 2:
                return "High";
            case 3:
                return "Very High";
            default:
                return "Unknown";
        }
    }
}
