package com.yyk.sz.zhzy.zjxt.zjutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: ZhangChao
 * @Date: 2018/12/3 19:47
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(ZJUtil.getZJData().getDd_tg());
        System.out.println(ZJUtil.getZJData().getTime_tg());
        System.out.println(ZJUtil.getZJData().getTime_dz());
        System.out.println(ZJUtil.getZJData().getG_time_invalid_end());

        for (int i=0;i<100;i++){
            System.out.println(UUID.randomUUID().toString().replace("-", ""));
            System.out.println((UUID.randomUUID().toString().replace("-", "")).length());
        }

    }
}
