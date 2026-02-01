package com.samsung.sensorapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.samsung.sensorapp.manager.SensorDataManager;
import com.samsung.sensorapp.manager.SensorEventListener;
import com.samsung.sensorapp.model.SensorData;
import com.samsung.sensorapp.model.SensorInfo;
import com.samsung.sensorapp.ui.adapter.SensorDataAdapter;
import com.samsung.sensorapp.ui.adapter.SensorInfoAdapter;

import java.util.ArrayList;
import java.util.List;
import android.hardware.SensorManager;

/**
 * Main activity displaying available sensors and their real-time data
 */
public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.BODY_SENSORS,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    private SensorDataManager sensorDataManager;
    private ListView sensorListView;
    private ListView sensorDataListView;
    private Button toggleMonitoringButton;
    private Button viewAllSensorsButton;
    private TextView statusTextView;
    private TextView sensorCountTextView;

    private SensorInfoAdapter sensorInfoAdapter;
    private SensorDataAdapter sensorDataAdapter;
    private List<SensorInfo> availableSensors;
    private List<SensorData> sensorDataList;

    private boolean isMonitoring = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        sensorDataManager = new SensorDataManager(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkAndRequestPermissions();
        } else {
            loadSensors();
        }
    }

    private void initializeUI() {
        sensorListView = findViewById(R.id.sensor_list_view);
        sensorDataListView = findViewById(R.id.sensor_data_list_view);
        toggleMonitoringButton = findViewById(R.id.toggle_monitoring_button);
        viewAllSensorsButton = findViewById(R.id.view_all_sensors_button);
        statusTextView = findViewById(R.id.status_text_view);
        sensorCountTextView = findViewById(R.id.sensor_count_text_view);

        availableSensors = new ArrayList<>();
        sensorDataList = new ArrayList<>();

        sensorInfoAdapter = new SensorInfoAdapter(this, availableSensors);
        sensorDataAdapter = new SensorDataAdapter(this, sensorDataList);

        sensorListView.setAdapter(sensorInfoAdapter);
        sensorDataListView.setAdapter(sensorDataAdapter);

        toggleMonitoringButton.setOnClickListener(v -> toggleMonitoring());
        viewAllSensorsButton.setOnClickListener(v -> viewAllSensors());

        updateStatusUI();
    }

    private void checkAndRequestPermissions() {
        List<String> permissionsToRequest = new ArrayList<>();

        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }

        if (!permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    permissionsToRequest.toArray(new String[0]),
                    PERMISSION_REQUEST_CODE);
        } else {
            loadSensors();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            loadSensors();
        }
    }

    private void loadSensors() {
        availableSensors.clear();
        List<Sensor> sensors = sensorDataManager.getAvailableSensors();

        for (Sensor sensor : sensors) {
            availableSensors.add(new SensorInfo(sensor, true, sensor.getName()));
        }

        sensorInfoAdapter.notifyDataSetChanged();
        updateSensorCountUI();
        Toast.makeText(this, "Loaded " + availableSensors.size() + " sensors",
                Toast.LENGTH_SHORT).show();
    }

    private void toggleMonitoring() {
        if (isMonitoring) {
            stopMonitoring();
        } else {
            startMonitoring();
        }
    }

    private void startMonitoring() {
        int[] commonSensors = {
                Sensor.TYPE_ACCELEROMETER,
                Sensor.TYPE_MAGNETIC_FIELD,
                Sensor.TYPE_GYROSCOPE,
                Sensor.TYPE_LIGHT,
                Sensor.TYPE_PRESSURE,
                Sensor.TYPE_AMBIENT_TEMPERATURE,
                Sensor.TYPE_RELATIVE_HUMIDITY,
                Sensor.TYPE_PROXIMITY
        };

        int registeredCount = 0;
        for (int sensorType : commonSensors) {
            if (sensorDataManager.isSensorAvailable(sensorType)) {
                sensorDataManager.registerListener(sensorType, new SensorEventListener() {
                    @Override
                    public void onSensorDataChanged(SensorData sensorData) {
                        updateUI(sensorData);
                    }

                    @Override
                    public void onSensorAccuracyChanged(int accuracy) {
                    }

                    @Override
                    public void onSensorError(String errorMessage) {
                        showError(errorMessage);
                    }
                }, SensorManager.SENSOR_DELAY_NORMAL);
                registeredCount++;
            }
        }

        isMonitoring = true;
        updateStatusUI();
        Toast.makeText(this, "Monitoring " + registeredCount + " sensor(s)",
                Toast.LENGTH_SHORT).show();
    }

    private void stopMonitoring() {
        sensorDataManager.unregisterAllListeners();
        isMonitoring = false;
        sensorDataList.clear();
        sensorDataAdapter.notifyDataSetChanged();
        updateStatusUI();
        Toast.makeText(this, "Monitoring stopped", Toast.LENGTH_SHORT).show();
    }

    private void viewAllSensors() {
        loadSensors();
    }

    private void updateUI(SensorData sensorData) {
        runOnUiThread(() -> sensorDataAdapter.updateSensorData(sensorData));
    }

    private void updateStatusUI() {
        String status = isMonitoring ? "● Monitoring Active" : "○ Monitoring Inactive";
        int textColor = isMonitoring ? getResources().getColor(android.R.color.holo_green_dark) :
                getResources().getColor(R.color.text_inactive);

        statusTextView.setText(status);
        statusTextView.setTextColor(textColor);

        toggleMonitoringButton.setText(isMonitoring ? "⏸ Stop Monitoring" : "▶ Start Monitoring");
        toggleMonitoringButton.setBackgroundColor(isMonitoring ?
                getResources().getColor(android.R.color.holo_red_dark) :
                getResources().getColor(android.R.color.holo_green_dark));
    }

    private void updateSensorCountUI() {
        sensorCountTextView.setText("Available Sensors: " + availableSensors.size());
    }

    private void showError(String errorMessage) {
        runOnUiThread(() -> Toast.makeText(MainActivity.this, "Error: " + errorMessage,
                Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (sensorDataManager != null) {
            sensorDataManager.unregisterAllListeners();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isMonitoring) {
            stopMonitoring();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();}
}