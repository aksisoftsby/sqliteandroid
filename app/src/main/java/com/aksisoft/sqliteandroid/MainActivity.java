package com.aksisoft.sqliteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.aksisoft.sqlite.dbmeta.dbinfo;
import com.aksisoft.sqlite.helper.sqtString;
import com.aksisoft.sqlite.sqt;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivityBOS";
    sqt sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sq = new sqt(this);
        // Log.d(TAG, sqtString.create("namatable", new String[]{"tbl1", "tbl2", "tbl3"}));
        // Log.d(TAG, dbinfo.getProjection(dbinfo.sFeed).toString());
    }
}