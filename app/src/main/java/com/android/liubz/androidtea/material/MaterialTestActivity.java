package com.android.liubz.androidtea.material;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Toast;

import com.android.liubz.androidtea.R;

public class MaterialTestActivity extends Activity {

    private TextInputLayout mUserNameLayout;
    private TextInputLayout mPasswordLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_test);

        initViews();
    }

    private void initViews() {
        mUserNameLayout = findViewById(R.id.username_layout);
        mPasswordLayout = findViewById(R.id.password_layout);
    }

    public void showSnackbar(View view) {
        Snackbar.make(findViewById(R.id.activity_snackbar), "标题", Snackbar.LENGTH_LONG)
                .setAction("点击事件", v -> Toast.makeText(MaterialTestActivity.this,
                        "Snackbar", Toast.LENGTH_SHORT).show()).show();
    }

    public void login(View view) {
        String password = mPasswordLayout.getEditText().getText().toString();
        if (!validatePassword(password)) {
            mPasswordLayout.setErrorEnabled(true);
            mPasswordLayout.setError("密码字数过少");
        } else {
            mPasswordLayout.setErrorEnabled(false);
        }
    }

    private boolean validatePassword(String password) {
        return password != null && password.length() > 5;
    }
}
