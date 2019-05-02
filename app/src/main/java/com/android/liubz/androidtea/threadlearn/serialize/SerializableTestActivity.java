package com.android.liubz.androidtea.threadlearn.serialize;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.android.liubz.androidtea.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTestActivity extends Activity {
    private static final String TAG = "SerializableTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable_test);

    }

    @SuppressLint("LongLogTag")
    public void readData(View v) {
        Teacher teacher = new Teacher();
        teacher.name = "Hui";
        teacher.course = "Chinese";
        teacher.tClass = 3;
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.i(TAG, "external storage dir: " + path);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path + "/cache.txt"));
            oos.writeObject(teacher);
        } catch (IOException e) {
            Log.e(TAG, "IOException: ", e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(path + "/cache.txt"));
            Teacher t = (Teacher) in.readObject();
            Log.i(TAG, "readData: teacher: " + t);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "ClassNotFoundException: ", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
