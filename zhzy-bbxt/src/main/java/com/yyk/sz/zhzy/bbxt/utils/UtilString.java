package com.yyk.sz.zhzy.bbxt.utils;

public class UtilString {

    public static String judgeNull(String str){
        return str != null && str.trim().length() == 0 ? null : str;
    }
}
