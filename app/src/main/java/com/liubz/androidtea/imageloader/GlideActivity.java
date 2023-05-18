package com.liubz.androidtea.imageloader;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/18 3:54 PM
 */
public class GlideActivity extends BaseActivity {
    @BindView(R.id.image_view)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        Glide.with(this)
          .load("https://img-home.csdnimg.cn/images/20230406105129.png")
          .centerCrop()
          .into(imageView);
    }
}
