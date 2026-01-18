package com.liubz.androidtea.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BookProvider extends ContentProvider {
    public static final String AUTHORITY = "com.liubz.androidtea.book.provider";
    
    private static final int BOOK_DIR = 0;
    private static final int BOOK_ITEM = 1;
    
    private static final UriMatcher sUriMatcher;
    private BookDbHelper mDbHelper;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(AUTHORITY, "books", BOOK_DIR);
        sUriMatcher.addURI(AUTHORITY, "books/#", BOOK_ITEM);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = BookDbHelper.getInstance(this.getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (sUriMatcher.match(uri)) {
            case BOOK_DIR:
                cursor = db.query(BookDbHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                cursor = db.query(BookDbHelper.TABLE_NAME, projection, BookDbHelper.COLUMN_ID + "=?", new String[]{bookId}, null, null, sortOrder);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd." + AUTHORITY + ".books";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd." + AUTHORITY + ".books";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (sUriMatcher.match(uri)) {
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookId = db.insert(BookDbHelper.TABLE_NAME, null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/books/" + newBookId);
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int deletedRows = 0;
        switch (sUriMatcher.match(uri)) {
            case BOOK_DIR:
                deletedRows = db.delete(BookDbHelper.TABLE_NAME, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                deletedRows = db.delete(BookDbHelper.TABLE_NAME, BookDbHelper.COLUMN_ID + "=?", new String[]{bookId});
                break;
        }
        return deletedRows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int updatedRows = 0;
        switch (sUriMatcher.match(uri)) {
            case BOOK_DIR:
                updatedRows = db.update(BookDbHelper.TABLE_NAME, values, selection, selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                updatedRows = db.update(BookDbHelper.TABLE_NAME, values, BookDbHelper.COLUMN_ID + "=?", new String[]{bookId});
                break;
        }
        return updatedRows;
    }
}
