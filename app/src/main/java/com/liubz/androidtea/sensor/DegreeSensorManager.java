package com.liubz.androidtea.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;
import static android.hardware.Sensor.TYPE_GYROSCOPE;
import static android.hardware.Sensor.TYPE_MAGNETIC_FIELD;

public class DegreeSensorManager {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor, magneticSensor, gyroScopeSensor;
    private Gyro3DSensorListener gyro3DSensorListener;
    private GyroSensorListener gyroSensorListener;

    public void initSensor(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        //获取Sensor
        magneticSensor = sensorManager.getDefaultSensor(TYPE_MAGNETIC_FIELD);
        accelerometerSensor = sensorManager.getDefaultSensor(TYPE_ACCELEROMETER);
        gyroScopeSensor = sensorManager.getDefaultSensor(TYPE_GYROSCOPE);

    }

    public void registerListener() {
        if (sensorManager != null && magneticSensor != null && accelerometerSensor != null) {
            gyro3DSensorListener = new Gyro3DSensorListener();
            gyroSensorListener = new GyroSensorListener();
            Log.i("GyroSensorManager", "registerListener");
            sensorManager.registerListener(gyro3DSensorListener, magneticSensor, SensorManager.SENSOR_DELAY_GAME);
            sensorManager.registerListener(gyro3DSensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
            sensorManager.registerListener(gyroSensorListener, gyroScopeSensor, SensorManager.SENSOR_DELAY_GAME);
        }
    }
}
