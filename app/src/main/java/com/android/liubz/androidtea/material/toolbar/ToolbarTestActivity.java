package com.android.liubz.androidtea.material.toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.liubz.androidtea.R;

public class ToolbarTestActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private TextView mCloseTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test);

        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void initViews() {
        mCloseTextView = findViewById(R.id.tv_close);
        mToolbar = findViewById(R.id.my_toolbar);
        mToolbar.setTitle("Toolbar");
        setSupportActionBar(mToolbar);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.closed);
        Palette.from(bitmap).generate(palette -> {
            Palette.Swatch swatch = palette.getVibrantSwatch();
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(swatch.getRgb()));
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icon);
        mToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_settings:
                    Toast.makeText(ToolbarTestActivity.this,
                            "action setttings", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_share:
                    Toast.makeText(ToolbarTestActivity.this,
                            "action share", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        });
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.drawer_open, R.string.drawer_close);
        mToggle.syncState();
        mDrawerLayout.setDrawerListener(mToggle);
        mCloseTextView.setOnClickListener(v -> mDrawerLayout.closeDrawer(Gravity.LEFT));
    }
}
