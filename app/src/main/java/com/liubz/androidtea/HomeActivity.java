package com.liubz.androidtea;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.example.baseinterface.BaseInterface;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.communicate.CommunicationActivity;
import com.liubz.androidtea.container.ContainerActivity;
import com.liubz.androidtea.expandablelist.MyExpandableListActivity;
import com.liubz.androidtea.imageloader.GlideActivity;
import com.liubz.androidtea.immersive.ImmersiveActivity;
import com.liubz.androidtea.network.WebViewTestActivity;
import com.liubz.androidtea.network.retrofit.page.RetrofitActivity;
import com.liubz.androidtea.notification.NewTaskActivity;
import com.liubz.androidtea.rx.RxActivity;
import com.liubz.androidtea.stack.launchmode.DialogActivity;
import com.liubz.androidtea.stack.launchmode.LaunchModeActivity;
import com.liubz.androidtea.stack.launchmode.TransparentActivity;
import com.liubz.androidtea.utils.ScreenUtils;
import com.liubz.androidtea.utils.StatusBarUtil;
import com.liubz.androidtea.view.EditTextActivity;

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

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";

    private SensorManager sensormanager;
    private SensorEventListener listener;
    private Sensor accelerometerSensor;
    private Sensor magneticSensor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("HomeActivity");
        ButterKnife.bind(this);
        Log.i(TAG, "onCreate");

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

    @OnClick(R.id.expandable_list_activity)
    void launchExpandableListActivity() {
        startActivity(new Intent(this, MyExpandableListActivity.class));
    }

    @OnClick(R.id.edit_text_activity)
    void launchEditTextActivity() {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    @OnClick(R.id.launch_webview)
    void onClick() {
        Intent intent = new Intent(this, WebViewTestActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.retrofit_activity)
    void startRetrofitActivity() {
        startActivity(new Intent(this, RetrofitActivity.class));
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
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.rx_java3_activity)
    void launchRxActivity() {
        startActivity(new Intent(this, RxActivity.class));
    }

    @OnClick(R.id.service_loader)
    void serviceLoader() {
//        ServiceLoader<BaseInterface> sl = ServiceLoader.load(BaseInterface.class);
//        Iterator<BaseInterface> iter = sl.iterator();
//        while (iter.hasNext()) {
//            BaseInterface bi = iter.next();
//            Log.i(TAG, bi.getClass().getName() + ": " + bi.name());
//        }

        try {
            Enumeration<URL> enumeration = Thread.currentThread().getContextClassLoader().getResources("META-INF/services/" + BaseInterface.class.getName());
            Log.i(TAG, "serviceLoader: enumeration: " + enumeration);
//            Log.i(TAG, "serviceLoader: hasMoreElements: " + enumeration.hasMoreElements());
//            URL nextElement = enumeration.nextElement();
//            Log.i(TAG, "serviceLoader: next Element: " + nextElement);
            Iterator<String> pending = null;
            while ((pending == null) || !pending.hasNext()) {
                if (!enumeration.hasMoreElements()) {
                    return;
                }
                pending = parse(BaseInterface.class, enumeration.nextElement());
                Log.i(TAG, "serviceLoader: pending: " + pending + ", hasNext: " + pending.hasNext());
            }
            Log.i(TAG, "serviceLoader: parse result: " + pending.next());
//            while (enumeration.hasMoreElements()) {
//                Log.i(TAG, "serviceLoader: elements: " + enumeration.nextElement());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.classloader)
    void classLoader() {

        String classpath, bootPath, extPath;

        try {
            classpath = System.getProperty("java.class.path");
            bootPath = System.getProperty("sun.boot.class.path");
            extPath = System.getProperty("java.ext.dirs");
            Log.i(TAG, "classLoader-classpath: " + classpath + ", bootPath: " + bootPath + ", extPath: " + extPath);
        } catch (SecurityException e) {
        }

        ClassLoader loader = HomeActivity.class.getClassLoader();
        while (loader != null) {
            Log.i(TAG, "classLoader: " + loader);
            loader = loader.getParent();
        }

    }

    @OnClick(R.id.go_to_other_app_activity)
    void goToSecondActivity() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.learnopengles.android",
          "com.learnopengles.android.lesson_OpenGL_ES_2.TriangleActivity"));
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.container_activity)
    void goContainerActivity() {
        startActivity(new Intent(this, ContainerActivity.class));
    }

    @OnClick(R.id.communicate_activity)
    void goCommunicateActivity() {
        startActivity(new Intent(this, CommunicationActivity.class));
    }

    private Iterator<String> parse(Class<?> service, URL u)
      throws ServiceConfigurationError {
        Log.i(TAG, "parse: service: " + service + ", url: " + u);
        InputStream in = null;
        BufferedReader r = null;
        ArrayList<String> names = new ArrayList<>();
        try {
            in = u.openStream();
            r = new BufferedReader(new InputStreamReader(in, "utf-8"));
            int lc = 1;
            while ((lc = parseLine(service, u, r, lc, names)) >= 0) ;
        } catch (IOException x) {
            Log.e(TAG, "parse: exception", x);
//            fail(service, "Error reading configuration file", x);
        } finally {
            try {
                if (r != null) r.close();
                if (in != null) in.close();
            } catch (IOException y) {
//                fail(service, "Error closing configuration file", y);
            }
        }
        return names.iterator();
    }

    @OnClick(R.id.launch_launch_mode)
    void launchLaunchModeActivity() {
        Intent intent = new Intent(this, LaunchModeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.launch_new_task)
    void launchNewTask() {
        Intent intent = new Intent(this, NewTaskActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick(R.id.launch_mode_transparent_btn)
    void launchTransparentActivity() {
        startActivity(new Intent(this, TransparentActivity.class));
    }

    @OnClick(R.id.launch_mode_dialog_activity_btn)
    void launchDialogActivity() {
        startActivity(new Intent(this, DialogActivity.class));
    }

    @OnClick(R.id.immersive_page)
    void launchImmersiveActivity() {
        Intent intent = new Intent(this, ImmersiveActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.get_status_bar_height)
    void getStatusBarHeight() {
        Toast.makeText(HomeActivity.this, "状态栏高度：" + StatusBarUtil.getStatusBarHeight(this), Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.show_alert_dialog)
    void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder.setTitle("欢迎来到Android世界")
          .setMessage("这个是一个AlertDialog")
          .setCancelable(true)
          .setPositiveButton("确认", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          })
          .setNegativeButton("取消", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          })
          .setOnCancelListener(new DialogInterface.OnCancelListener() {
              @Override
              public void onCancel(DialogInterface dialog) {
                  Log.i(TAG, "AlertDialog onCancel");
              }
          })
          .create();
        dialog.show();
    }

    @OnClick(R.id.glide_activity)
    void goGlideActivity() {
        startActivity(new Intent(this, GlideActivity.class));
    }

    private int parseLine(Class<?> service, URL u, BufferedReader r, int lc,
                          List<String> names)
      throws IOException, ServiceConfigurationError {
        String ln = r.readLine();
        if (ln == null) {
            return -1;
        }
        int ci = ln.indexOf('#');
        if (ci >= 0) ln = ln.substring(0, ci);
        ln = ln.trim();
        int n = ln.length();
        if (n != 0) {
            if ((ln.indexOf(' ') >= 0) || (ln.indexOf('\t') >= 0)) {
                //                fail(service, u, lc, "Illegal configuration-file syntax");
            }
            int cp = ln.codePointAt(0);
            if (!Character.isJavaIdentifierStart(cp))
//                fail(service, u, lc, "Illegal provider-class name: " + ln);
                for (int i = Character.charCount(cp); i < n; i += Character.charCount(cp)) {
                    cp = ln.codePointAt(i);
                    if (!Character.isJavaIdentifierPart(cp) && (cp != '.')) {

                    }
//                    fail(service, u, lc, "Illegal provider-class name: " + ln);
                }
            names.add(ln);
//            if (!providers.containsKey(ln) && !names.contains(ln))
//
        }
        return lc + 1;
    }

    @OnClick(R.id.phone_info)
    void getPhoneInfo() {
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        String te1 = tm.getLine1Number(); // 获取本机号码  
        Log.i(TAG, "getPhoneInfo: tel: " + te1);
//        String deviceid = tm.getDeviceId(); // 获取智能设备唯一编号  
//
//        String imei = tm.getSimSerialNumber(); // 获得SIM卡的序号  
//        String imsi = tm.getSubscriberId(); // 得到用户Id  
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

    @OnClick(R.id.screen_info)
    void outputScreenInfo() {
        ScreenUtils.outputDensityInfo(this);
    }
}
