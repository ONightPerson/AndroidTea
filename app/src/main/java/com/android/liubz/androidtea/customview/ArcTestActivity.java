package com.android.liubz.androidtea.customview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.R;
import com.android.liubz.androidtea.Worker;
import com.android.liubz.androidtea.interprocess.SecondActivity;

public class ArcTestActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "ArcTestActivity";

    private Button mBtn;
    private String mStr = "default";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_test);

        Worker worker = (Worker) getIntent().getSerializableExtra("extra.worker");

        Log.i(TAG, "onCreate: worker: " + worker);
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: mStr: " + mStr);
    }

    private void initViews() {
        mBtn = findViewById(R.id.play);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtn) {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            mStr = "go to second activity";
        }
    }
}
