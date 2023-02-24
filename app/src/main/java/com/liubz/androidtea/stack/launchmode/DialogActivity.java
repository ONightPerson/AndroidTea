package com.liubz.androidtea.stack.launchmode;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/19 6:22 PM
 */
@SuppressWarnings("LongLogTag")
public class DialogActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("DialogActivity");
        setTitleColor(Color.RED);
        LinearLayout layout = new LinearLayout(this);
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.message);
        layout.addView(iv);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
        params.gravity = Gravity.CENTER;
        params.width = LinearLayout.LayoutParams.MATCH_PARENT;
        params.height = LinearLayout.LayoutParams.MATCH_PARENT;

        setContentView(layout);
    }
}
