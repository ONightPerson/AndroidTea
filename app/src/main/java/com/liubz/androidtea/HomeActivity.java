package com.liubz.androidtea;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.interprocess.SecondActivity;
import com.liubz.androidtea.rx.RxActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private SensorManager sensormanager;
    private SensorEventListener listener;
    private Sensor accelerometerSensor;
    private Sensor magneticSensor;

    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);

//        testSensor();

        // 陀螺仪传感器
//        DegreeSensorManager manager = new DegreeSensorManager();
//        manager.initSensor(this);
//        manager.registerListener();
        initSensor();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterSensor();
    }

    @OnClick(R.id.btn)
    void onClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    private void registerSensor() {
        //更新速率：提到游戏的规格上
        sensormanager.registerListener(listener, magneticSensor, SensorManager.SENSOR_DELAY_GAME);
        sensormanager.registerListener(listener, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    private void unregisterSensor() {
        sensormanager.unregisterListener(listener, magneticSensor);
        sensormanager.unregisterListener(listener, accelerometerSensor);
    }

    private void initSensor() {
         /*
        传感器的创建
        1、先创建传感器管理器，管理所有传感器
        2、传入参数，指定特定传感器
        3、注册
        4、结束，注销传感器
         */
        // 1、获取传感器管理服务对象
        sensormanager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 2、特定传观器对象获取: 方向传感器
        accelerometerSensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magneticSensor = sensormanager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        // 3、注册监听器，来实时的更改操作
        //监听器：精确度更改会立即执行onSensorChanged方法
        listener = new SensorEventListener() {
            private float[] accelerometer = new float[3];
            private float[] magnetic = new float[3];

            @Override
            public void onSensorChanged(SensorEvent event) {
                //判断当前是什么传感器
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    //使用clone来取值
                    accelerometer = event.values.clone();
                } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                    magnetic = event.values.clone();
                }
                float[] R = new float[9];
                float[] values = new float[3];
                if (accelerometer.length != 0 && magnetic.length != 0) {
                    //根据传输的数据，计算转动角度,将结果放进长度为9的数组中
                    sensormanager.getRotationMatrix(R, null, accelerometer, magnetic);
                    //根据上面计算出的旋转矩阵R，在计算旋转角度，存进values中
                    sensormanager.getOrientation(R, values);
                    //弧度转换成角度
                    Log.i(TAG, "onSensorChanged: " + Math.toDegrees(values[0]));
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
}
