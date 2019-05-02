package com.android.liubz.androidtea.music.aidl;

import android.os.RemoteException;
import android.util.Log;

public class MusicManagerService extends IMusicManagerService.Stub {
    private static final String TAG = "MusicManagerService";

    @Override
    public void startPlay() throws RemoteException {
        Log.i(TAG, "startPlay: ");
    }

    @Override
    public void stopPlay() throws RemoteException {
        Log.i(TAG, "stopPlay: ");
    }

    @Override
    public void next() throws RemoteException {
        Log.i(TAG, "next: ");
    }

    @Override
    public void previous() throws RemoteException {
        Log.i(TAG, "previous: ");
    }
}
