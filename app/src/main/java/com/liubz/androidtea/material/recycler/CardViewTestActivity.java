package com.liubz.androidtea.material.recycler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.widget.SeekBar;

import com.liubz.androidtea.Constants;
import com.liubz.androidtea.R;

public class CardViewTestActivity extends Activity {
    private static final String TAG = "CardViewTestActivity" + Constants.CARD_VIEW_SUFFIX;

    private CardView mCardView;
    private SeekBar mChangeCornerSb;
    private SeekBar mChangeShadowSb;
    private SeekBar mChangeDistanceSb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_test);

        initViews();
    }

    @SuppressLint("LongLogTag")
    private void initViews() {
        mCardView = findViewById(R.id.card_view);
        mChangeCornerSb = findViewById(R.id.change_corner);
        mChangeShadowSb = findViewById(R.id.change_shadow);
        mChangeDistanceSb = findViewById(R.id.change_distance);

        mChangeCornerSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "mChangeCornerSb: progress: " + progress);
                mCardView.setRadius(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mChangeShadowSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "mChangeShadowSb: progress: " + progress);
                mCardView.setCardElevation(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mChangeDistanceSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "mChangeDistanceSb: progress: " + progress);
                mCardView.setContentPadding(progress, progress, progress, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
