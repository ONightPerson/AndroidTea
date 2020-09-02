package com.liubz.androidtea;

import com.liubz.androidtea.modules.ui.MyActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private static final int TAKE_PHOTO = 1;

    private Button mClickLaunchBtn;
    private Uri mImageUri;

    private int count = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        initViews();

    }


    private void initViews() {
        mClickLaunchBtn = findViewById(R.id.click_to_launch);
        mClickLaunchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mClickLaunchBtn) {
//            UsageUtils.startTargetIntentIfNeeded(this);
//            UsageUtils.printEventStats(this);
//            startActivity(FlutterActivity.withCachedEngine("flutter_engine").build(this));
            startActivity(new Intent(this, MyActivity.class));
        }
    }
}
