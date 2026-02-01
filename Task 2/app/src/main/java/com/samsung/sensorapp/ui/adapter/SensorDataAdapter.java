package com.samsung.sensorapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.samsung.sensorapp.R;
import com.samsung.sensorapp.model.SensorData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Adapter for displaying real-time sensor data readings
 */
public class SensorDataAdapter extends ArrayAdapter<SensorData> {
    private final Context context;
    private final List<SensorData> sensorDataList;
    private final LayoutInflater inflater;
    private final SimpleDateFormat dateFormat;

    public SensorDataAdapter(Context context, List<SensorData> sensorDataList) {
        super(context, 0, sensorDataList);
        this.context = context;
        this.sensorDataList = sensorDataList;
        this.inflater = LayoutInflater.from(context);
        this.dateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SensorDataViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_sensor_data, parent, false);
            holder = new SensorDataViewHolder();
            holder.sensorNameValue = convertView.findViewById(R.id.sensor_name_value);
            holder.sensorDataValue = convertView.findViewById(R.id.sensor_data_value);
            holder.accuracyLabel = convertView.findViewById(R.id.accuracy_label);
            holder.timestampLabel = convertView.findViewById(R.id.timestamp_label);
            convertView.setTag(holder);
        } else {
            holder = (SensorDataViewHolder) convertView.getTag();
        }

        SensorData sensorData = sensorDataList.get(position);
        
        holder.sensorNameValue.setText(sensorData.getSensorName());
        holder.sensorDataValue.setText(sensorData.getFormattedValues() + " " + sensorData.getUnit());
        holder.accuracyLabel.setText("Accuracy: " + sensorData.getAccuracyString());
        
        String timestamp = dateFormat.format(new Date(sensorData.getTimestamp() / 1_000_000));
        holder.timestampLabel.setText("Time: " + timestamp);

        return convertView;
    }

    /**
     * Update a sensor data item and notify the adapter
     */
    public void updateSensorData(SensorData newData) {
        int index = -1;
        for (int i = 0; i < sensorDataList.size(); i++) {
            if (sensorDataList.get(i).getSensorType() == newData.getSensorType()) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            sensorDataList.set(index, newData);
            notifyDataSetChanged();
        } else {
            sensorDataList.add(newData);
            notifyDataSetChanged();
        }
    }

    /**
     * ViewHolder pattern for efficient list rendering
     */
    private static class SensorDataViewHolder {
        TextView sensorNameValue;
        TextView sensorDataValue;
        TextView accuracyLabel;
        TextView timestampLabel;
    }
}
