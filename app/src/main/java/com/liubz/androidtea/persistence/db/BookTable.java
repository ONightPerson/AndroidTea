package com.liubz.androidtea.persistence.db;

public class BookTable {

    public static String CREATE_BOOK_TABLE = "CREATE TABLE IF NOT EXISTS Book" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "book_name TEXT," +
            "author TEXT," +
            "pages INTEGER);";

    public static String ADD_COLUMN_CATEGORY_NAME = "alter table Book " +
            "add category TEXT;";
}
