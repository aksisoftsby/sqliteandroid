package com.aksisoft.sqliteandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.aksisoft.sqlite.helper.sqtString;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivityBOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, sqtString.create("namatable", new String[]{
                "tbl1", "tbl2", "tbl3"
        }));
    }
}