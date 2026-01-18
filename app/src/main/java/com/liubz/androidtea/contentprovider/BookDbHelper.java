package com.liubz.androidtea.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "book_store.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "books";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AUTHOR = "author";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_AUTHOR + " TEXT NOT NULL)";

    private static volatile BookDbHelper sInstance;

    // 使用单例模式确保整个进程内数据库连接唯一
    public static BookDbHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (BookDbHelper.class) {
                if (sInstance == null) {
                    sInstance = new BookDbHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private BookDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        // 核心优化：开启预写日志 (WAL) 模式，显著提高并发读写性能
        db.enableWriteAheadLogging();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
