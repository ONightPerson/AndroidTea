package com.liubz.androidtea;

import java.util.Map;
import java.util.Set;

import com.liubz.androidtea.classloader.ClassLoaderUtils;
import com.liubz.androidtea.modules.usage.UsageUtils;
import com.liubz.androidtea.utils.TimeUtils;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
            ClassLoaderUtils.showClassLoaderRelations(this);
        }
    }

    private void showUsageStats() {
        UsageUtils.startTargetIntentIfNeeded(this);
        UsageStatsManager usm = (UsageStatsManager) getSystemService(Context.USAGE_STATS_SERVICE);
        long endTime = System.currentTimeMillis();
        long startTime = endTime - 8 * 60 * 60 * 1000L;
        Map<String, Long> stats = UsageUtils.getUsageStatsMap(usm, startTime, endTime);
        Set<Map.Entry<String, Long>> entries = stats.entrySet();
        for (Map.Entry<String, Long> entry : entries) {
            Log.i(TAG,
                    "showUsageStats: pkg: " + entry.getKey() + ", usage: "
                            + TimeUtils.getUTCTimeString(entry.getValue()));
        }
    }
}
