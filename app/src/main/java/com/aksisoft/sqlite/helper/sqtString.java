package com.aksisoft.sqlite.helper;

import android.text.TextUtils;

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

}
