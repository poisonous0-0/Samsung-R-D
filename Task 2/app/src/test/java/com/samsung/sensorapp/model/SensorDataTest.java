package com.samsung.sensorapp.model;

import android.hardware.Sensor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for SensorData model class
 */
@RunWith(MockitoJUnitRunner.class)
public class SensorDataTest {

    @Mock
    private Sensor mockSensor;

    private SensorData sensorData;

    @Before
    public void setUp() {
        float[] values = {1.0f, 2.0f, 3.0f};
        sensorData = new SensorData(
                "Test Sensor",
                Sensor.TYPE_ACCELEROMETER,
                values,
                2,
                System.nanoTime(),
                "m/s²"
        );
    }

    @Test
    public void testSensorDataCreation() {
        assertEquals("Test Sensor", sensorData.getSensorName());
        assertEquals(Sensor.TYPE_ACCELEROMETER, sensorData.getSensorType());
        assertEquals("m/s²", sensorData.getUnit());
        assertEquals(2, sensorData.getAccuracy());
    }

    @Test
    public void testGetFormattedValues() {
        String formatted = sensorData.getFormattedValues();
        assertEquals("1.00, 2.00, 3.00", formatted);
    }

    @Test
    public void testGetAccuracyString() {
        SensorData lowAccuracy = new SensorData(
                "Test",
                Sensor.TYPE_ACCELEROMETER,
                new float[]{1.0f},
                0,
                System.nanoTime(),
                "m/s²"
        );
        assertEquals("Low", lowAccuracy.getAccuracyString());

        SensorData highAccuracy = new SensorData(
                "Test",
                Sensor.TYPE_ACCELEROMETER,
                new float[]{1.0f},
                3,
                System.nanoTime(),
                "m/s²"
        );
        assertEquals("Very High", highAccuracy.getAccuracyString());
    }

    @Test
    public void testGetFormattedValuesWithEmptyArray() {
        SensorData emptyData = new SensorData(
                "Test",
                Sensor.TYPE_ACCELEROMETER,
                new float[]{},
                0,
                System.nanoTime(),
                "m/s²"
        );
        assertEquals("No data", emptyData.getFormattedValues());
    }

    @Test
    public void testGetFormattedValuesWithNullArray() {
        SensorData nullData = new SensorData(
                "Test",
                Sensor.TYPE_ACCELEROMETER,
                null,
                0,
                System.nanoTime(),
                "m/s²"
        );
        assertEquals("No data", nullData.getFormattedValues());
    }

    @Test
    public void testGetValues() {
        float[] values = sensorData.getValues();
        assertEquals(3, values.length);
        assertEquals(1.0f, values[0], 0.01f);
        assertEquals(2.0f, values[1], 0.01f);
        assertEquals(3.0f, values[2], 0.01f);
    }
}
