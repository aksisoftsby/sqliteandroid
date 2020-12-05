package com.aksisoft.sqlite.dbmeta;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.aksisoft.sqlite.helper.sqtConstant;
import com.aksisoft.sqlite.helper.sqtString;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbinfo {

    // database informasi
    // akun
    public static final String tblFeed = "feed";
    public static final String Feed_title = "title";
    public static final String Feed_caption = "caption";
    public static final String Feed_image1 = "image1";
    public static final String[] Feed_projection = new String[]{
            Feed_title, Feed_caption, Feed_image1
    };

    public static final String tblUser = "user";
    public static final String User_name = "name";
    public static final String User_username = "username";
    public static final String User_description = "description";
    public static final String User_image1 = "image1";
    public static final String[] User_projection = new String[]{
            User_name, User_username, User_description, User_image1
    };

    public static final Map<String, String[]> TBL = new HashMap<String, String[]>(){{
        put(tblFeed, Feed_projection);
        put(tblUser, User_projection);
    }};

    public static final Map<String, String> TITLE =
            new HashMap<String, String>(){{
    }};

    public static final String getTitle(String validation){
        switch (validation){
            case Feed_image1:
                return "Image";
        }
        return validation.substring(0,1).toUpperCase()
                + validation.substring(1);
    }
}
