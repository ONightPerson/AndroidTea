package com.android.liubz.androidtea.persistence.litepal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.R;

import org.litepal.LitePal;

public class LitePalTestActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "LitePalTestActivity";

    private Button mCreateDb;
    private Button mAddTable;
    private Button mDeleteTable;
    private Button mUpdateTable;
    private Button mQueryTable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepal_test);

        assignViews();
    }

    private void assignViews() {
        mCreateDb = (Button) findViewById(R.id.create_db);
        mCreateDb.setOnClickListener(this);
        mAddTable = (Button) findViewById(R.id.add_table);
        mAddTable.setOnClickListener(this);
        mDeleteTable = (Button) findViewById(R.id.delete_table);
        mDeleteTable.setOnClickListener(this);
        mUpdateTable = (Button) findViewById(R.id.update_table);
        mUpdateTable.setOnClickListener(this);
        mQueryTable = (Button) findViewById(R.id.query_table);
        mQueryTable.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mCreateDb) {
            Log.i(TAG, "onClick: mCreateDb");
            LitePal.getDatabase();
        } else if (v == mAddTable) {
            Student student = new Student();
            student.setName("xiaoqing");
            student.setNo("20091152");
            student.setNumber("19233333333");
            student.setScore(4);
            student.setAddr("HeNan");
            student.save();
        } else if (v == mUpdateTable) {
            Student student = new Student();
            student.setAddr("HuBei");
            student.updateAll("name = ?", "liubz");
        } else if (v == mDeleteTable) {
            LitePal.deleteAll(Student.class, "name = ?", "liubz");
        }
    }
}
