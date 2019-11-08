package com.yyk.sz.common.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaofs on 2017/4/14.
 * 字符分割工具
 */
public class UtilStrSplit {
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰命名分割
     * @param camelCase 驼峰命名方式的名称字符串
     * @param split 分割符
     * @return 分割后的字符串
     */
    public static String  splitCamelCase(String camelCase,String split){
        Matcher matcher = humpPattern.matcher(camelCase);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, split+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.indexOf(split)==0?sb.toString().replaceFirst(split,""):sb.toString();
    }

}
