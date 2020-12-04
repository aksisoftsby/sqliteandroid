package com.aksisoft.sqlite.helper;

import android.text.TextUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class sqtString {

    public static final String tblID(){
        return TextUtils.join(sqtConstant.space, new String[] {
                sqtConstant.id,
                sqtConstant.integer,
                sqtConstant.primary,
                sqtConstant.key,
                sqtConstant.auto_increment
        });
    }

    public static final String text(String s){
        return TextUtils.join(sqtConstant.space, new String[] {
                s,
                sqtConstant.text,
                // sqtConstant.notnull
                sqtConstant.nul
        });
    }

    public static final String _create_first(String tbl){
        return TextUtils.join(sqtConstant.space, new String[]{
           sqtConstant.create,
           sqtConstant.table,
           tbl,
           sqtConstant.openBracket
        });
    }

    // standard create
    public static final String create(String tbl, String[] s){
        List<String> l = new ArrayList<>();
        l.add(_create_first(tbl));

        List<String> ln = new ArrayList<String>();
        ln.add(tblID());
        for(int i = 0; i < s.length; i++){
            ln.add(text(s[i]));
        }
        l.add(TextUtils.join(sqtConstant.comma + sqtConstant.space, ln.toArray()));

        l.add(sqtConstant.closeBracket);
        // l.add(sqtConstant.dotComma);
        return TextUtils.join(sqtConstant.newLine, l.toArray());
    }

    public static final String delete(String tbl){
        return TextUtils.join(sqtConstant.space, new String[]{
           sqtConstant.drop,
           sqtConstant.table,
           sqtConstant.iff,
           sqtConstant.exist,
           tbl
        });
    }

}
