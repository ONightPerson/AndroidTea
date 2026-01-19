package com.liubz.androidtea.binderpool;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BinderPool {
    private static final String TAG = "BinderPool";
    public static final int BINDER_NONE = -1;
    public static final int BINDER_SECURITY_CENTER = 0;
    public static final int BINDER_COMPUTE = 1;

    private final Context mContext;
    private IBinderPool mBinderPool;
    private static volatile BinderPool sInstance;
    private CountDownLatch mConnectBinderPoolCountDownLatch;

    private BinderPool(Context context) {
        mContext = context.getApplicationContext();
        connectBinderPoolService();
    }

    public static BinderPool getInstance(Context context) {
        if (sInstance == null) {
            synchronized (BinderPool.class) {
                if (sInstance == null) {
                    sInstance = new BinderPool(context);
                }
            }
        }
        return sInstance;
    }

    private synchronized void connectBinderPoolService() {
        mConnectBinderPoolCountDownLatch = new CountDownLatch(1);
        Intent service = new Intent(mContext, BinderPoolService.class);
        mContext.bindService(service, mBinderPoolConnection, Context.BIND_AUTO_CREATE);
        // 注意：这里不再进行 await()，将阻塞时机推迟到真正查询时
    }

    /**
     * 根据 binderCode 查询对应的 Binder 实体
     * 这是一个耗时操作，严禁在主线程调用
     */
    public IBinder queryBinder(int binderCode) {
        // 核心优化 1：安全性检查，防止主线程死锁
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("queryBinder cannot be called from the main thread.");
        }

        try {
            // 核心优化 2：按需同步等待连接完成（带超时保护）
            if (mBinderPool == null) {
                Log.d(TAG, "Waiting for binder pool connection...");
                boolean success = mConnectBinderPoolCountDownLatch.await(5, TimeUnit.SECONDS);
                if (!success) {
                    Log.e(TAG, "Connect binder pool timeout!");
                    return null;
                }
            }

            if (mBinderPool != null) {
                return mBinderPool.queryBinder(binderCode);
            }
        } catch (InterruptedException | RemoteException e) {
            Log.e(TAG, "queryBinder failed", e);
        }
        return null;
    }

    private final ServiceConnection mBinderPoolConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBinderPool = IBinderPool.Stub.asInterface(service);
            try {
                mBinderPool.asBinder().linkToDeath(mBinderPoolDeathRecipient, 0);
            } catch (RemoteException e) {
                Log.e(TAG, "linkToDeath failed", e);
            }
            // 释放阻塞，唤醒 queryBinder 线程
            mConnectBinderPoolCountDownLatch.countDown();
            Log.d(TAG, "Binder pool connected success.");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBinderPool = null;
        }
    };

    private final IBinder.DeathRecipient mBinderPoolDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.d(TAG, "binder died, reconnecting...");
            mBinderPool.asBinder().unlinkToDeath(mBinderPoolDeathRecipient, 0);
            mBinderPool = null;
            connectBinderPoolService();
        }
    };

    /**
     * 连接池的 Stub 实现
     */
    public static class BinderPoolImpl extends IBinderPool.Stub {
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder = null;
            switch (binderCode) {
                case BINDER_SECURITY_CENTER:
                    binder = new SecurityCenterImpl();
                    break;
                case BINDER_COMPUTE:
                    binder = new ComputeImpl();
                    break;
                default:
                    break;
            }
            return binder;
        }
    }
}
