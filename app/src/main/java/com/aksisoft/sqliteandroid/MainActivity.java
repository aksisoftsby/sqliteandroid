package com.aksisoft.sqliteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aksisoft.sqlite.dbfunc;
import com.aksisoft.sqlite.dbmeta.dbinfo;
import com.aksisoft.sqlite.helper.sqtString;
import com.aksisoft.sqlite.sqt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String TAG = "MainActivityBOS";
    sqt sq;
    Button btntop, btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sq = new sqt(this);

        btntop = findViewById(R.id.btnTop);
        btnshow = findViewById(R.id.btnShow);
        btntop.setOnClickListener(this);
        btnshow.setOnClickListener(this);
        // Log.d(TAG, sqtString.create("namatable", new String[]{"tbl1", "tbl2", "tbl3"}));
        // Log.d(TAG, dbinfo.getProjection(dbinfo.sFeed).toString());

    }

    @Override
    public void onClick(final View vi) {
        if (btntop.equals(vi)) {
            ContentValues c = new ContentValues();
            c.put(dbinfo.Feed_title, new Date().toString());
            dbfunc._insert(sq, dbinfo.tblFeed, c);
        } else if (btnshow.equals(vi)) {
            List<Object> l = dbfunc.getAll(sq, dbinfo.tblFeed);
            dbfunc._log(l);
        }
    }
}