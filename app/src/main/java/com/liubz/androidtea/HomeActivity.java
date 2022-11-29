package com.liubz.androidtea;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baseinterface.BaseInterface;
import com.liubz.androidtea.network.WebViewTestActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private SensorManager sensormanager;
    private SensorEventListener listener;
    private Sensor accelerometerSensor;
    private Sensor magneticSensor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        Log.i(TAG, "onCreate: ");

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

    @OnClick(R.id.task)
    void onClick() {
        startActivity(new Intent(this, WebViewTestActivity.class));
    }

    @OnClick(R.id.call_phone)
    void callPhone() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:17611490712"));
        startActivity(intent);
    }

    @OnClick(R.id.launch_browser)
    void launchBrowser() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
        startActivity(intent);
    }

    @OnClick(R.id.service_loader)
    void serviceLoader() {
        ServiceLoader<BaseInterface> sl = ServiceLoader.load(BaseInterface.class);
        Iterator<BaseInterface> iter = sl.iterator();
        while (iter.hasNext()) {
            BaseInterface bi = iter.next();
            Log.i(TAG, bi.getClass().getName() + ": " + bi.name());
        }

        try {
            Enumeration<URL> enumeration = Thread.currentThread().getContextClassLoader().getResources("META-INF/services/" + BaseInterface.class.getName());
            Log.i(TAG, "serviceLoader: enumeration: " + enumeration);
            Log.i(TAG, "serviceLoader: hasMoreElements: " + enumeration.hasMoreElements());
            parse(BaseInterface.class, enumeration.nextElement());
            while (enumeration.hasMoreElements()) {
                Log.i(TAG, "serviceLoader: elements: " + enumeration.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Iterator<String> parse(Class<?> service, URL u)
            throws ServiceConfigurationError
    {
        InputStream in = null;
        BufferedReader r = null;
        ArrayList<String> names = new ArrayList<>();
        try {
            in = u.openStream();
            r = new BufferedReader(new InputStreamReader(in, "utf-8"));
            int lc = 1;
            while ((lc = parseLine(service, u, r, lc, names)) >= 0);
        } catch (IOException x) {
        } finally {
        }
        return names.iterator();
    }

    private int parseLine(Class<?> service, URL u, BufferedReader r, int lc,
                          List<String> names)
            throws IOException, ServiceConfigurationError
    {
        String ln = r.readLine();
        if (ln == null) {
            return -1;
        }
        int ci = ln.indexOf('#');
        if (ci >= 0) ln = ln.substring(0, ci);
        ln = ln.trim();
        int n = ln.length();
        if (n != 0) {
//            if ((ln.indexOf(' ') >= 0) || (ln.indexOf('\t') >= 0))
//                fail(service, u, lc, "Illegal configuration-file syntax");
            int cp = ln.codePointAt(0);
//            if (!Character.isJavaIdentifierStart(cp))
//                fail(service, u, lc, "Illegal provider-class name: " + ln);
            for (int i = Character.charCount(cp); i < n; i += Character.charCount(cp)) {
                cp = ln.codePointAt(i);
//                if (!Character.isJavaIdentifierPart(cp) && (cp != '.'))
//                    fail(service, u, lc, "Illegal provider-class name: " + ln);
            }
//            if (!providers.containsKey(ln) && !names.contains(ln))
//                names.add(ln);
        }
        return lc + 1;
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
//                    Log.i(TAG, "onSensorChanged: " + Math.toDegrees(values[0]));
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
}
