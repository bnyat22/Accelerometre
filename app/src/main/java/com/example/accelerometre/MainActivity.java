package com.example.accelerometre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

 private    SensorManager sensorManager ;
 private ConstraintLayout constraintLayout;
 TextView textView;
    Accelermeter accelermeterListener;
 float x , y ,z ,t;

 Sensor accemeletor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = (ConstraintLayout) findViewById(R.id.content);
        sensorManager  = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accemeletor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        textView = (TextView) findViewById(R.id.text);
         accelermeterListener = new Accelermeter(constraintLayout , textView);
         sensorManager.registerListener(accelermeterListener , accemeletor , SensorManager.SENSOR_DELAY_GAME);


    }




}
