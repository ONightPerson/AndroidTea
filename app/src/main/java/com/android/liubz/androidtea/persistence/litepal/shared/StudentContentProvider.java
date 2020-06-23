package com.android.liubz.androidtea.persistence.litepal.shared;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.litepal.LitePal;

public class StudentContentProvider extends ContentProvider {
    private static final String TAG = StudentContentProvider.class.getSimpleName();

    public static final int STUDENT_DIR = 0;
    public static final int STUDENT_ITEM = 1;
    public static final String AUTHORITY = "com.android.liubz.androidtea.StudentContentProvider";

    private static UriMatcher sUriMatcher;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, "student", STUDENT_DIR);
        sUriMatcher.addURI(AUTHORITY, "student/#", STUDENT_ITEM);
    }

    @Override
    public boolean onCreate() {
        LitePal.useDefault();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (sUriMatcher.match(uri)) {
            case STUDENT_DIR:
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
