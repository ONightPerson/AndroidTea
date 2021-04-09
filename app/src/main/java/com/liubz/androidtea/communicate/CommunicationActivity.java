package com.liubz.androidtea.communicate;

import com.liubz.androidtea.R;
import com.liubz.androidtea.communicate.eventbus.EventBusActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;

/**
 * Created by liubaozhu on 2021/4/9
 */
public class CommunicationActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communicate_categories);
    }

    public void goEventBus(View view) {
        startActivity(new Intent(this, EventBusActivity.class));
    }
}
