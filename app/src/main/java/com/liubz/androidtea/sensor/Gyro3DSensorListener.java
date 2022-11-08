package com.liubz.androidtea.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class Gyro3DSensorListener implements SensorEventListener {
    private static final String TAG = "Gyro3DSensorListener";

    private float[] gravity, r, geomagnetic, values;
    double mDegreeZ, mDegreeX, mDegreeY;

    private float targetDegree =0.0f;


    public Gyro3DSensorListener() {
        //初始化数组
        gravity = new float[3];//用来保存加速度传感器的值
        r = new float[9];
        geomagnetic = new float[3];//用来保存地磁传感器的值
        values = new float[3];//用来保存最终的结果

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            geomagnetic = event.values.clone();
        }else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            gravity = event.values.clone();
        }
        getOrientation();
        calculateOrientation(gravity, geomagnetic);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * 获取手机旋转角度
     */
    public void getOrientation() {
        // r从这里返回
        SensorManager.getRotationMatrix(r, null, gravity, geomagnetic);
        //values从这里返回
        SensorManager.getOrientation(r, values);
        //提取数据
        mDegreeZ = Math.toDegrees(values[0]);
        mDegreeX = Math.toDegrees(values[1]);
        mDegreeY = Math.toDegrees(values[2]);
        Log.i(TAG, "getOrientation: mDegreeX: " + mDegreeX + ", mDegreeY: " + mDegreeY
                + ", mDegreeZ: " + mDegreeZ);
    }

    public void calculateOrientation(float[] gravity, float[] geomagnetic){
        float[] values = new float[3];
        float[] R = new float[9];
        SensorManager.getRotationMatrix(R, null, gravity, geomagnetic);
        SensorManager.getOrientation(R, values);
        values[0] = (float)Math.toDegrees(values[0]);
        Log.d(TAG," calculateOrientation() values[0]="+values[0] );
        targetDegree = (-values[0]+360.0f) % 360;
        Log.i(TAG, "calculateOrientation: targetDegree: " + targetDegree);

    }


}
