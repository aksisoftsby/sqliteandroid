package com.aksisoft.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aksisoft.sqlite.dbmeta.dbinfo;

import androidx.annotation.Nullable;

public class sqt extends SQLiteOpenHelper {

    private static final String DB_NAME = "databaseapp.sql";
    private static final Integer DB_VERSION = 2;

    public sqt(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // db.execSQL(dbinfo.onCreate());
        dbinfo.onCreate(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // db.execSQL(dbinfo.onDelete());
        dbinfo.onDelete(db);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
        // super.onDowngrade(db, oldVersion, newVersion);
    }
}
