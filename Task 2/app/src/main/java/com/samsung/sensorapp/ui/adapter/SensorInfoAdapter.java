package com.samsung.sensorapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.samsung.sensorapp.R;
import com.samsung.sensorapp.model.SensorInfo;

import java.util.List;

/**
 * Adapter for displaying available sensors in a ListView
 */
public class SensorInfoAdapter extends ArrayAdapter<SensorInfo> {
    private final Context context;
    private final List<SensorInfo> sensors;
    private final LayoutInflater inflater;

    public SensorInfoAdapter(Context context, List<SensorInfo> sensors) {
        super(context, 0, sensors);
        this.context = context;
        this.sensors = sensors;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SensorViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_sensor_info, parent, false);
            holder = new SensorViewHolder();
            holder.sensorName = convertView.findViewById(R.id.sensor_name);
            holder.sensorType = convertView.findViewById(R.id.sensor_type);
            holder.sensorDetails = convertView.findViewById(R.id.sensor_details);
            holder.sensorStatus = convertView.findViewById(R.id.sensor_status);
            convertView.setTag(holder);
        } else {
            holder = (SensorViewHolder) convertView.getTag();
        }

        SensorInfo sensorInfo = sensors.get(position);
        holder.sensorName.setText(sensorInfo.getName());
        holder.sensorType.setText("Type: " + sensorInfo.getType());
        holder.sensorDetails.setText(String.format(
                "Power: %.2f mA | Range: %.2f | Vendor: %s",
                sensorInfo.getPower(),
                sensorInfo.getMaximumRange(),
                sensorInfo.getVendor()
        ));
        holder.sensorStatus.setText(sensorInfo.isAvailable() ? "Available" : "Not Available");

        return convertView;
    }

    /**
     * ViewHolder pattern for efficient list rendering
     */
    private static class SensorViewHolder {
        TextView sensorName;
        TextView sensorType;
        TextView sensorDetails;
        TextView sensorStatus;
    }
}
