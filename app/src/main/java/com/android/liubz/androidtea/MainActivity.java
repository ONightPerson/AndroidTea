package com.android.liubz.androidtea;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.customview.ArcTestActivity;
import com.android.liubz.androidtea.network.SignalStrengthTestActivity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private static final int TAKE_PHOTO = 1;

    private Button mClickLaunchBtn;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mClickLaunchBtn = findViewById(R.id.click_to_launch);
        mClickLaunchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == mClickLaunchBtn) {
//            Intent intent = new Intent(this, AccessibilityTestActivity.class);
//
//            AccessibilityJumpActivity.show(this, intent);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("https://www.baidu.com"));
//            startActivity(intent);
//            Intent intent = new Intent(this, AccessibilityTestActivity.class);
//            AccessibilityJumpActivity.show(this, intent);

            Intent intent = new Intent(this, ArcTestActivity.class);
            startActivity(intent);
//            Log.i(TAG, "bluetooth address: " + getBtAddressByReflection());
//            Log.e(TAG, "bluetooth address: " + BluetoothAdapter.getDefaultAdapter().getAddress());

//            Log.i(TAG, "onClick: filepath:" + getFilesDir().getAbsolutePath() + "/");

//            Intent intent = new Intent(this, SignalStrengthTestActivity.class);
//            startActivity(intent);
//
//            String IP = "192.168.31.143";
//            try {
//                Process p = Runtime.getRuntime().exec("ping -c 1 -W 1 " + IP);
//                int status = p.waitFor();
//                Log.e(TAG, "status: " + status);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            Intent intent = new Intent(this, MyIntentService.class);
//            intent.putExtra("task_action", "task1");
//            startService(intent);
//
//            Intent intent1 = new Intent(this, MyIntentService.class);
//            intent1.putExtra("task_action", "task2");
//            startService(intent1);
//
//
//            Intent intent2 = new Intent(this, MyIntentService.class);
//            intent2.putExtra("task_action", "task3");
//            startService(intent2);


//            UDPScanner.doScan(this);

//            mImageUri = ImageUtils.getImageUri(this, "output_image.jpg");
//            // 启动相机程序
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
//            startActivityForResult(intent, TAKE_PHOTO);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        // 展示拍摄的照片
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(mImageUri));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    public static String getBtAddressByReflection() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Field field = null;
        try {
            field = BluetoothAdapter.class.getDeclaredField("mService");
            field.setAccessible(true);
            Object bluetoothManagerService = field.get(bluetoothAdapter);
            if (bluetoothManagerService == null) {
                return null;
            }
            Method method = bluetoothManagerService.getClass().getMethod("getAddress");
            if(method != null) {
                Object obj = method.invoke(bluetoothManagerService);
                if(obj != null) {
                    return obj.toString();
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
