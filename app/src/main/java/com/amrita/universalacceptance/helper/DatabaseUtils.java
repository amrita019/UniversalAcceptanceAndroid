package com.amrita.universalacceptance.helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUtils extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db";
    private static final int DATABASE_VERSION = 1;
    private static final String INPUT_TABLE_NAME = "notestable";
    public static final String INPUT_COLUMN_ID = "_id";
    public static final String INPUT_COLUMN_Name = "name";
    public static final String INPUT_COLUMN_Email = "email";

    public DatabaseUtils(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + INPUT_TABLE_NAME + "(" +
                INPUT_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                INPUT_COLUMN_Name + " TEXT, " +
                INPUT_COLUMN_Email + " TEXT )"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + INPUT_TABLE_NAME);
        onCreate(db);
    }


    public void insertEmail(String title, String text) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INPUT_COLUMN_Name, title);
        contentValues.put(INPUT_COLUMN_Email, text);
        db.insert(INPUT_TABLE_NAME, null, contentValues);
    }


    public Cursor getAllEmail() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery( "SELECT * FROM " + INPUT_TABLE_NAME, null );
    }

}

