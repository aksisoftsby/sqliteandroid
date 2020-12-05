package com.aksisoft.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.text.TextUtils;
import android.util.Log;

import com.aksisoft.sqlite.dbmeta.dbinfo;
import com.aksisoft.sqlite.helper.sqtConstant;
import com.aksisoft.sqlite.helper.sqtString;
import com.aksisoft.sqlite.table.tbl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbfunc {

    public static final String TAG = "dbfunc";

    public static final String order_desc(String table){
        return TextUtils.join(sqtConstant.space, new String[] { table, sqtConstant.desc });
    }

    public static final void onCreate(SQLiteDatabase sq){
        List<String> l = new ArrayList<String>();
        for(Map.Entry<String, String[]> e : dbinfo.TBL.entrySet()){
            // l.add(sqtString.create(e.getKey(), e.getValue()));
            sq.execSQL(sqtString.create(e.getKey(), e.getValue()));
        }
        // return TextUtils.join(sqtConstant.space, l.toArray());
    }
    public static final void onDelete(SQLiteDatabase sq){
        List<String> l = new ArrayList<String>();
        for(Map.Entry<String, String[]> e : dbinfo.TBL.entrySet()){
            // l.add(sqtString.delete(e.getKey()));
            sq.execSQL(sqtString.delete(e.getKey()));
        }
        // return TextUtils.join(sqtConstant.space, l.toArray());
    }

    public static final void _close(Cursor c, SQLiteDatabase s){
        c.close(); s.close();
    }

    public static List<Object> _list(Cursor c, String[] projection){
        List<Object> l = new ArrayList<Object>();
        while (c.moveToNext()){
            Map<String, String> m = new HashMap<String, String>();
            m.put(sqtConstant.id, c.getString(c.getColumnIndex(sqtConstant.id)));
            for(int i = 0; i < projection.length; i++){
                m.put(projection[i], c.getString(c.getColumnIndex(projection[i])));
            }
            l.add(m);
        }
        return l;
    }

    public static List<Object> getAll(sqt sqt, String tb){
        SQLiteDatabase s = sqt.getReadableDatabase();
        Cursor c = s.query(tb,
                null,
                null,
                null,
                null,
                null,
                order_desc(sqtConstant.id));
        // TODO: memory alternatives
        List<Object> l = _list(c, dbinfo.TBL.get(tb));
        _close(c, s);
        return l;
    }

    public static Map<String, String> getWhere(sqt sqt, String tb, String tbname, String tbVal){
        SQLiteDatabase s = sqt.getReadableDatabase();
        Cursor c = s.rawQuery(tbl.rawSelectWhere(tb, tbname), new String[]{ tbVal });
        List<Object> l = _list(c, dbinfo.TBL.get(tb));
        _close(c, s);
        if(l.size() > 0) return (Map<String, String>) l.get(0);
         else return null;
    }

    public static final void _insert(sqt sq, String tbl, ContentValues cv){
        SQLiteDatabase s = sq.getWritableDatabase();
        s.insert(tbl, null, cv);
        s.close();
    }
    public static final void _log(List<Object> l){
        for (int i = 0; i<l.size(); i++){
            Log.d(TAG, l.get(i).toString());
        }
    }
    public static final void _log(Map<String, String> m){
        Log.d(TAG, m.toString());
    }
}
