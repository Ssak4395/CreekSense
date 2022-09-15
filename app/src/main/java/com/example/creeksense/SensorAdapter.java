package com.example.creeksense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder> {

    Sensor[] mySensorData;
    Context context;

    public SensorAdapter(Sensor[] mySensorData, Context context) {
        this.mySensorData = mySensorData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.graph_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           final Sensor sensorDataList = mySensorData[position];
           holder.SensorID.setText(sensorDataList.getSensorTitle());
           holder.SensorStatus.setText("ONLINE");
           holder.SensorLocation.setText("LAT-LONG");
           holder.SensorType.setText("AQUATIC");
    }

    @Override
    public int getItemCount() {
        return mySensorData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView SensorID;
        TextView SensorLocation;
        TextView SensorType;
        TextView SensorStatus;

        Button sensorData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SensorID = itemView.findViewById(R.id.sensor_id_text);
            SensorStatus = itemView.findViewById(R.id.sensor_status_text);
            SensorLocation = itemView.findViewById(R.id.sensor_location_text);
            SensorType = itemView.findViewById(R.id.sensor_type_text);

            sensorData = itemView.findViewById(R.id.view_data_card_button);
        }
    }
}
