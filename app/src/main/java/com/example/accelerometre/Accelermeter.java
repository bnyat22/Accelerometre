package com.example.accelerometre;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Accelermeter implements SensorEventListener {
    float x ,y,z ,t;
    ConstraintLayout constraintLayout;

    TextView textView;
    public Accelermeter(ConstraintLayout constraintLayout , TextView textView)
    {
        this.constraintLayout  = constraintLayout;
        this.textView = textView;
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
        {
            constraintLayout.setBackgroundColor(Color.YELLOW);
            return;
        }

        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        t  = x + y +z;
        textView.setText(String.valueOf(t));
        if (t <= - 2)
        {
            constraintLayout.setBackgroundColor(Color.GREEN);
        } else if (t > -2 && t <= 4)
            constraintLayout.setBackgroundColor(Color.BLACK);
        else
            constraintLayout.setBackgroundColor(Color.RED);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
