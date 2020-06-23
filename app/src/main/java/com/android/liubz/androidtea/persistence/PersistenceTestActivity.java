package com.android.liubz.androidtea.persistence;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.android.liubz.androidtea.persistence.db.BookSQLiteOpenHelper;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PersistenceTestActivity extends Activity {
    private static final String TAG = "PersistenceTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        saveByFile();
        saveByPreference();
        saveBySql();
    }

    private void saveByFile() {
        FileOutputStream out;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("tmp", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write("Hello World");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void saveByPreference() {
        SharedPreferences preferences = getSharedPreferences("tag", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("is_contained", true);
        editor.putString("name", "liubz");
        editor.apply();
    }

    private void saveBySql() {
        BookSQLiteOpenHelper helper = BookSQLiteOpenHelper.fetchInstance(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        database.execSQL("insert into Book(book_name, author, pages, category) values(\"知之深 爱之切\", \"习近平\", 499, \"政治\");");
    }
}
