package com.android.liubz.androidtea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.service.accessibility.AccessibilityJumpActivity;
import com.android.liubz.androidtea.service.accessibility.AccessibilityTestActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mClickLaunchBtn;

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
            Intent intent = new Intent(this, AccessibilityTestActivity.class);
            
            AccessibilityJumpActivity.show(this, intent);
        }
    }
}
