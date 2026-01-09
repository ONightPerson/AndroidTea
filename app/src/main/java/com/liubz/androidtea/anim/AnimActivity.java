package com.liubz.androidtea.anim;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;

public class AnimActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);

        startAnim();
    }

    private void startAnim() {
        Button button = findViewById(R.id.button);
        ObjectAnimator animator = ObjectAnimator.ofFloat(button, "translationY", 0, 50, 200);
        animator.setStartDelay(500);
        animator.setDuration(1000);
        animator.start();
    }
}
