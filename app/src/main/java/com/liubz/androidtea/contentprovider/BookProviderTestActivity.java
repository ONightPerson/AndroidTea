package com.liubz.androidtea.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityBookProviderTestBinding;

public class BookProviderTestActivity extends AppCompatActivity {
    private static final String TAG = "BookProviderTest";
    private ActivityBookProviderTestBinding binding;
    private final Uri BOOK_URI = Uri.parse("content://com.liubz.androidtea.book.provider/books");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookProviderTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("BookProvider 测试");

        initListeners();
    }

    private void initListeners() {
        binding.btnInsert.setOnClickListener(v -> insertBook());
        binding.btnQuery.setOnClickListener(v -> queryBooks());
        binding.btnUpdate.setOnClickListener(v -> updateBook());
        binding.btnDelete.setOnClickListener(v -> deleteBook());
    }

    private void insertBook() {
        ContentValues values = new ContentValues();
        values.put("name", "Android 进阶解密");
        values.put("author", "刘望舒");
        Uri newUri = getContentResolver().insert(BOOK_URI, values);
        showResult("插入成功: " + newUri);
    }

    private void queryBooks() {
        Cursor cursor = getContentResolver().query(BOOK_URI, null, null, null, null);
        if (cursor == null) {
            showResult("查询失败，Cursor 为空");
            return;
        }

        // 1. 在循环外预取列索引，提高性能
        int idIndex = cursor.getColumnIndex(BookDbHelper.COLUMN_ID);
        int nameIndex = cursor.getColumnIndex(BookDbHelper.COLUMN_NAME);
        int authorIndex = cursor.getColumnIndex(BookDbHelper.COLUMN_AUTHOR);

        // 2. 检查列是否存在，防止返回 -1
        if (idIndex == -1 || nameIndex == -1 || authorIndex == -1) {
            showResult("查询失败：数据库表中缺少必要的列 (_id, name, author)");
            cursor.close();
            return;
        }

        // 3. 检查是否有数据
        if (cursor.getCount() == 0) {
            showResult("暂无书籍数据");
            cursor.close();
            return;
        }

        StringBuilder sb = new StringBuilder("查询结果：\n");
        while (cursor.moveToNext()) {
            // 4. 使用预取的索引，安全且高效
            int id = cursor.getInt(idIndex);
            String name = cursor.getString(nameIndex);
            String author = cursor.getString(authorIndex);

            sb.append("ID: ").append(id)
                    .append(", 书名: ").append(name)
                    .append(", 作者: ").append(author)
                    .append("\n");
        }
        cursor.close();
        showResult(sb.toString());
    }

    private void updateBook() {
        ContentValues values = new ContentValues();
        values.put("author", "匿名作者");
        // 这里为了演示，尝试更新所有书
        int count = getContentResolver().update(BOOK_URI, values, null, null);
        showResult("更新行数: " + count);
    }

    private void deleteBook() {
        // 这里为了演示，尝试删除所有书
        int count = getContentResolver().delete(BOOK_URI, null, null);
        showResult("删除行数: " + count);
    }

    private void showResult(String msg) {
        binding.tvResult.setText(msg);
        Log.d(TAG, msg);
    }
}
