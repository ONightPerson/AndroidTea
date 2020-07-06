package com.liubz.androidtea.persistence.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.util.Log;

public class BookSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "BookSQLiteOpenHelper";

    private static String DB_NAME = "Book.db";
    private static int VERSION = 2;


    private static volatile BookSQLiteOpenHelper sInstance;

    public static BookSQLiteOpenHelper fetchInstance(Context context) {
        if (sInstance == null) {
            synchronized (BookSQLiteOpenHelper.class) {
                if (sInstance == null) {
                    sInstance = new BookSQLiteOpenHelper(context.getApplicationContext(), DB_NAME,
                            null, VERSION);
                }
            }
        }
        return sInstance;
    }


    public BookSQLiteOpenHelper(@Nullable Context context, @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 首次安装时调用
        Log.i(TAG, "onCreate: ");
        db.execSQL(BookTable.CREATE_BOOK_TABLE);
        db.execSQL(BookTable.ADD_COLUMN_CATEGORY_NAME);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 版本升级时调用
        Log.i(TAG, "onUpgrade: ");
        if (newVersion > 1) {
            db.execSQL(BookTable.ADD_COLUMN_CATEGORY_NAME);
        }
    }
}
