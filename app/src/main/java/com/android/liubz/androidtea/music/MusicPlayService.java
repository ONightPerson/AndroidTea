package com.android.liubz.androidtea.music;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.android.liubz.androidtea.music.aidl.MusicManagerService;

public class MusicPlayService extends Service {
    private static final String TAG = "MusicPlayService";

    public MusicPlayService() {
        Log.i(TAG, "MusicPlayService: Construct");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicManagerService();
    }
}
