package com.aksisoft.sqlite.table;

import android.text.TextUtils;

import com.aksisoft.sqlite.helper.sqtConstant;
import java.util.HashMap;
import java.util.Map;

public class tbl {

    public static final String orderBy = TextUtils.join(sqtConstant.space, new String[]{
            sqtConstant.orderby, sqtConstant.id, sqtConstant.desc
    });
    public static final String selectAll = TextUtils.join(sqtConstant.space, new String[]{
            sqtConstant.select, sqtConstant.star, sqtConstant.from
    });
    public static final String fromEscape(String tb){
        return TextUtils.join(sqtConstant.space, new String[]{
                sqtConstant.where, tb, sqtConstant.koma, sqtConstant.persenS
        });
    } ;
    public static final Map<String, String> _createName(String name){
        return new HashMap<String, String>(){{
           put(sqtConstant.name, name);
        }};
    }
    public static final Map<String, String> _createNameTitle(String name, String title){
        return new HashMap<String, String>(){{
            put(sqtConstant.name, name);
            put(sqtConstant.title, title);
        }};
    }
    public static final Map<String, String> _createTextarea(String name){
        return new HashMap<String, String>(){{
            put(sqtConstant.name, name);
            put(sqtConstant.type, sqtConstant.textarea);
        }};
    }
    public static final Map<String, String> _createImage(String name){
        return new HashMap<String, String>(){{
            put(sqtConstant.name, name);
            put(sqtConstant.type, sqtConstant.image);
        }};
    }

    public static final Map<String, String> name = new HashMap<String, String>(){{
        put(sqtConstant.name, tblConstant.name);
        put(sqtConstant.title, tblConstant.nameTitle);
    }};

    public static final Map<String, String> title = _createName(tblConstant.title);
    public static final Map<String, String> caption = _createTextarea(tblConstant.caption);
    public static final Map<String, String> hashtag = _createName(tblConstant.hashtag);

    public static final Map<String, String> image1 = _createImage(tblConstant.image1);
    public static final Map<String, String> image2 = _createImage(tblConstant.image2);
    public static final Map<String, String> image3 = _createImage(tblConstant.image3);
    public static final Map<String, String> image4 = _createImage(tblConstant.image4);
    public static final Map<String, String> image5 = _createImage(tblConstant.image5);

    public static final String getName(Map<String, String> o){ return o.get(sqtConstant.name);}
    public static final String getTitle(Map<String, String> o){
        if(o.get(sqtConstant.title) != null) return o.get(sqtConstant.title);
        else return o.get(sqtConstant.name).substring(0,1).toUpperCase()
            + o.get(sqtConstant.name).substring(1);
    }
    public static final String getType(Map<String, String> o){
        if(o.get(sqtConstant.type) != null) return o.get(sqtConstant.type);
        else return sqtConstant.text;
    }
    public static final String rawSelect(String tbl){
        return TextUtils.join(sqtConstant.space, new String[] {
                sqtConstant.select, sqtConstant.star, sqtConstant.from,
                tbl
        });
    }


    public static final String rawSelectWhere(String tbl, String colName){
        return TextUtils.join(sqtConstant.space, new String[]{
           selectAll, tbl, fromEscape(colName), orderBy
        });
    }
}
