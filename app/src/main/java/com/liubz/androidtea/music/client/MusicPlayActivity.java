package com.liubz.androidtea.music.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liubz.androidtea.R;
import com.liubz.androidtea.music.MusicPlayService;
import com.liubz.androidtea.music.aidl.IMusicManagerService;

public class MusicPlayActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MusicPlayActivity";

    private Button mPlay;
    private Button mStop;
    private Button mPrevious;
    private Button mNext;
    private IMusicManagerService mMusicManager;

    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.i(TAG, "binderDied: ");
            if (mMusicManager == null) {
                return;
            }
            mMusicManager.asBinder().unlinkToDeath(mDeathRecipient, 0);
            mMusicManager = null;
            // 重新绑定
        }
    };

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            try {
                service.linkToDeath(mDeathRecipient, 0);
                mMusicManager = IMusicManagerService.Stub.asInterface(service);
                mMusicManager.startPlay();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);

        assignViews();
        bindService();
    }

    private void assignViews() {
        mPlay = (Button) findViewById(R.id.play);
        mPlay.setOnClickListener(this);
        mStop = (Button) findViewById(R.id.stop);
        mStop.setOnClickListener(this);
        mPrevious = (Button) findViewById(R.id.previous);
        mPrevious.setOnClickListener(this);
        mNext = (Button) findViewById(R.id.next);
        mNext.setOnClickListener(this);
    }

    private void bindService() {
        Intent intent = new Intent(this, MusicPlayService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v == mPlay) {
            try {
                mMusicManager.startPlay();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (v == mStop) {
            try {
                mMusicManager.stopPlay();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (v == mPrevious) {
            try {
                mMusicManager.previous();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (v == mNext) {
            try {
                mMusicManager.next();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
