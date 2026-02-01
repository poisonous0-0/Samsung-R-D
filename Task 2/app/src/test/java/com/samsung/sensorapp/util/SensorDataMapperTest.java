package com.samsung.sensorapp.util;

import android.hardware.Sensor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for SensorDataMapper utility class
 */
public class SensorDataMapperTest {

    @Before
    public void setUp() {
        // Setup test environment
    }

    @Test
    public void testGetSensorUnitForAccelerometer() {
        String unit = SensorDataMapper.getSensorUnit(Sensor.TYPE_ACCELEROMETER);
        assertEquals("m/s²", unit);
    }

    @Test
    public void testGetSensorUnitForMagneticField() {
        String unit = SensorDataMapper.getSensorUnit(Sensor.TYPE_MAGNETIC_FIELD);
        assertEquals("µT", unit);
    }

    @Test
    public void testGetSensorUnitForGyroscope() {
        String unit = SensorDataMapper.getSensorUnit(Sensor.TYPE_GYROSCOPE);
        assertEquals("rad/s", unit);
    }

    @Test
    public void testGetSensorUnitForPressure() {
        String unit = SensorDataMapper.getSensorUnit(Sensor.TYPE_PRESSURE);
        assertEquals("hPa", unit);
    }

    @Test
    public void testGetSensorTypeNameForAccelerometer() {
        String name = SensorDataMapper.getSensorTypeName(Sensor.TYPE_ACCELEROMETER);
        assertEquals("Accelerometer", name);
    }

    @Test
    public void testGetSensorTypeNameForGyroscope() {
        String name = SensorDataMapper.getSensorTypeName(Sensor.TYPE_GYROSCOPE);
        assertEquals("Gyroscope", name);
    }

    @Test
    public void testGetSensorTypeNameUnknown() {
        String name = SensorDataMapper.getSensorTypeName(999);
        assertEquals("Unknown Sensor", name);
    }

    @Test
    public void testGetSensorDescriptionWithValidValues() {
        float[] values = {1.0f, 2.0f, 3.0f};
        String description = SensorDataMapper.getSensorDescription(Sensor.TYPE_ACCELEROMETER, values);
        assertNotNull(description);
    }

    @Test
    public void testGetSensorDescriptionWithNullValues() {
        String description = SensorDataMapper.getSensorDescription(Sensor.TYPE_ACCELEROMETER, null);
        assertEquals("No data available", description);
    }

    @Test
    public void testGetSensorDescriptionWithEmptyValues() {
        float[] values = {};
        String description = SensorDataMapper.getSensorDescription(Sensor.TYPE_ACCELEROMETER, values);
        assertEquals("No data available", description);
    }
}
