package com.yyk.sz.common.base.utils;

import java.text.DecimalFormat;

/**
 * Created by xujiashuai on 2016/6/20.
 */
public class UtilNumber {

    public static int parseInt(String num){
        try{
           return Integer.parseInt(num);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static float parseFloat(String num){
        try{
            return Float.parseFloat(num);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static double parseDouble(String num){
        try{
            return Double.parseDouble(num);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public static Long parseLong(String num){
        try{
            return Long.parseLong(num);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0L;
        }
    }

    public static String round2(double f){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        return decimalFormat.format(f);
    }
}
