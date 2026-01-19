package com.liubz.androidtea.binderpool;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityBinderPoolBinding;

public class BinderPoolActivity extends AppCompatActivity {
    private static final String TAG = "BinderPoolActivity";
    private ActivityBinderPoolBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBinderPoolBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Binder 连接池测试");

        initListeners();
    }

    private void initListeners() {
        binding.btnSecurity.setOnClickListener(v -> testSecurity());
        binding.btnCompute.setOnClickListener(v -> testCompute());
    }

    private void testSecurity() {
        new Thread(() -> {
            BinderPool binderPool = BinderPool.getInstance(this);
            IBinder securityBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
            ISecurityCenter securityCenter = SecurityCenterImpl.asInterface(securityBinder);
            
            try {
                String msg = "hello-binder-pool";
                String password = securityCenter.encrypt(msg);
                String result = "原文: " + msg + "\n加密后: " + password + "\n解密还原: " + securityCenter.decrypt(password);
                runOnUiThread(() -> binding.tvResult.setText(result));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void testCompute() {
        new Thread(() -> {
            BinderPool binderPool = BinderPool.getInstance(this);
            IBinder computeBinder = binderPool.queryBinder(BinderPool.BINDER_COMPUTE);
            ICompute compute = ComputeImpl.asInterface(computeBinder);
            
            try {
                int result = compute.add(100, 200);
                runOnUiThread(() -> binding.tvResult.setText("计算业务 (ICompute):\n100 + 200 = " + result));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
