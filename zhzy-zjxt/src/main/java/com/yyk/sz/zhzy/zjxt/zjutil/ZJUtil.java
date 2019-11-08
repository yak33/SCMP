package com.yyk.sz.zhzy.zjxt.zjutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 针灸工具类--子午流注算法
 * @Author: ZhangChao
 * @Date: 2018/12/3 11:17
 * @Version: 1.0
 */
public class ZJUtil {

    public static ZJResult getZJData() {
        String g_time_invalid_end = "";
        Calendar calendar = Calendar.getInstance();
        int my_year = calendar.get(Calendar.YEAR);
        int my_month = calendar.get(Calendar.MONTH) + 1;
        int my_day = calendar.get(Calendar.DATE);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
        String my_time = sdf.format(date);
        String my_date = sdfdate.format(date);

        String first_day2 = "";
        int mm_tg_push = 0;
        int mm_dz_push = 0;
        int i = 0;
        int first_day_tian_list = 0;
        int mm_tg_list = 0;
        int first_day_di_list = 0;
        int mm_dz_list = 0;
        String dd_dz = "";
        int day_tg_list = 0;
        int time_tg_list = 0;
        String time_dz = "";
        int time_dz_list = 0;
        String time_tg = "";
        int n = 0;
        String dd_tg = "";

        String[] tian_gan = new String[11];
        tian_gan[0] = "甲";
        tian_gan[1] = "甲";
        tian_gan[2] = "乙";
        tian_gan[3] = "丙";
        tian_gan[4] = "丁";
        tian_gan[5] = "戊";
        tian_gan[6] = "己";
        tian_gan[7] = "庚";
        tian_gan[8] = "辛";
        tian_gan[9] = "壬";
        tian_gan[10] = "癸";

        String[] di_zhi = new String[13];
        di_zhi[0] = "子";
        di_zhi[1] = "子";
        di_zhi[2] = "丑";
        di_zhi[3] = "寅";
        di_zhi[4] = "卯";
        di_zhi[5] = "辰";
        di_zhi[6] = "巳";
        di_zhi[7] = "午";
        di_zhi[8] = "未";
        di_zhi[9] = "申";
        di_zhi[10] = "酉";
        di_zhi[11] = "戌";
        di_zhi[12] = "亥";

        String[] first_day = new String[50];
        first_day[0] = "戊午";
        first_day[1] = "甲子";
        first_day[2] = "己巳";
        first_day[3] = "甲戌";
        first_day[4] = "己卯";
        first_day[5] = "乙酉";

        int[] ping_tian_mm = new int[13];
        ping_tian_mm[0] = -1;
        ping_tian_mm[1] = -1;
        ping_tian_mm[2] = 0;
        ping_tian_mm[3] = -2;
        ping_tian_mm[4] = -1;
        ping_tian_mm[5] = -1;
        ping_tian_mm[6] = 0;
        ping_tian_mm[7] = 0;
        ping_tian_mm[8] = 1;
        ping_tian_mm[9] = 2;
        ping_tian_mm[10] = 2;
        ping_tian_mm[11] = 3;
        ping_tian_mm[12] = 3;

        int[] ping_di_mm = new int[13];
        ping_di_mm[0] = -1;
        ping_di_mm[1] = -1;
        ping_di_mm[2] = 6;
        ping_di_mm[3] = 10;
        ping_di_mm[4] = 5;
        ping_di_mm[5] = -1;
        ping_di_mm[6] = 6;
        ping_di_mm[7] = 0;
        ping_di_mm[8] = 7;
        ping_di_mm[9] = 2;
        ping_di_mm[10] = 8;
        ping_di_mm[11] = 3;
        ping_di_mm[12] = 9;

        int[] run_tian_mm = new int[13];
        run_tian_mm[0] = -1;
        run_tian_mm[1] = -1;
        run_tian_mm[2] = 0;
        run_tian_mm[3] = 1;
        run_tian_mm[4] = 1;
        run_tian_mm[5] = 1;
        run_tian_mm[6] = 1;
        run_tian_mm[7] = 1;
        run_tian_mm[8] = 1;
        run_tian_mm[9] = 1;
        run_tian_mm[10] = 1;
        run_tian_mm[11] = 1;
        run_tian_mm[12] = 1;

        int[] run_di_mm = new int[13];
        run_di_mm[0] = -1;
        run_di_mm[1] = -1;
        run_di_mm[2] = 6;
        run_di_mm[3] = 1;
        run_di_mm[4] = 1;
        run_di_mm[5] = 1;
        run_di_mm[6] = 1;
        run_di_mm[7] = 1;
        run_di_mm[8] = 1;
        run_di_mm[9] = 1;
        run_di_mm[10] = 1;
        run_di_mm[11] = 1;
        run_di_mm[12] = 1;

        if (my_year - 2000 > 5) {
            first_day2 = "";
        } else {
            first_day2 = first_day[my_year - 2000];
        }

//        if ((my_year / 4) == Convert.ToInt32(my_year / 4))
//        {
//            mm_tg_push = run_tian_mm[my_month];
//            mm_dz_push = run_di_mm[my_month];
//        }
//        else
//        {
//            mm_tg_push = ping_tian_mm[my_month];
//            mm_dz_push = ping_di_mm[my_month];
//        }

        mm_tg_push = run_tian_mm[my_month];
        mm_dz_push = run_di_mm[my_month];

        for (int j = 1; j <= 10; j++) {
            if (first_day2.trim().length() == 0) {
                first_day_tian_list = 0;
            } else {
                if (first_day2.trim().substring(0, 1).trim().equals(tian_gan[j].trim())) {
                    first_day_tian_list = j;
                    break;
                }
            }
        }

        mm_tg_list = (first_day_tian_list + my_day + mm_tg_push) / 10;

        dd_tg = tian_gan[(first_day_tian_list + my_day + mm_tg_push - mm_tg_list) % 10];

        for (int j = 1; j <= 12; j++) {
            if (first_day2.trim().length() == 0) {
                first_day_di_list = 0;
            } else {
                if (di_zhi[j].trim().equals(first_day2.trim().substring(first_day2.trim().length() - 1, first_day2.trim().length() - 1 + 1))) {
                    first_day_di_list = j;
                    break;
                }
            }
        }


        mm_dz_list = (first_day_di_list + my_day + mm_dz_push) / 12;

        dd_dz = di_zhi[first_day_di_list + my_day + mm_dz_push - mm_dz_list * 12];

        //计算时辰天干
        for (int j = 1; j <= 10; j++) {
            if (dd_tg.trim().equals(tian_gan[j].trim())) {
                day_tg_list = j;    // 4
                break;
            }
        }
        if (day_tg_list > 5) {
            time_tg_list = (day_tg_list - 5) * 2 - 1;
        } else {
            time_tg_list = day_tg_list * 2 - 1; // 7
        }

        //计算时辰地支,同时设置失效时间
        try {
            long my_time_times = sdf.parse(my_time).getTime();

            if (my_time_times >= sdf.parse("23:00:00").getTime()
                    || my_time_times < sdf.parse("1:00:00").getTime()) {
                time_dz = "子";
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, 1);
                g_time_invalid_end = sdfdate.format(calendar.getTime()) + " 01:00:00";
            } else if (my_time_times >= sdf.parse("1:00:00").getTime()
                    && my_time_times < sdf.parse("3:00:00").getTime()) {
                time_dz = "丑";
                g_time_invalid_end = my_date + " 03:00:00";
            } else if (my_time_times >= sdf.parse("3:00:00").getTime()
                    && my_time_times < sdf.parse("5:00:00").getTime()) {
                time_dz = "寅";
                g_time_invalid_end = my_date + " 05:00:00";
            } else if (my_time_times >= sdf.parse("5:00:00").getTime()
                    && my_time_times < sdf.parse("7:00:00").getTime()) {
                time_dz = "卯";
                g_time_invalid_end = my_date + " 07:00:00";
            } else if (my_time_times >= sdf.parse("7:00:00").getTime()
                    && my_time_times < sdf.parse("9:00:00").getTime()) {
                time_dz = "辰";
                g_time_invalid_end = my_date + " 09:00:00";
            } else if (my_time_times >= sdf.parse("9:00:00").getTime()
                    && my_time_times < sdf.parse("11:00:00").getTime()) {
                time_dz = "巳";
                g_time_invalid_end = my_date + " 11:00:00";
            } else if (my_time_times >= sdf.parse("11:00:00").getTime()
                    && my_time_times < sdf.parse("13:00:00").getTime()) {
                time_dz = "午";
                g_time_invalid_end = my_date + " 13:00:00";
            } else if (my_time_times >= sdf.parse("13:00:00").getTime()
                    && my_time_times < sdf.parse("15:00:00").getTime()) {
                time_dz = "未";
                g_time_invalid_end = my_date + " 15:00:00";
            } else if (my_time_times >= sdf.parse("15:00:00").getTime()
                    && my_time_times < sdf.parse("17:00:00").getTime()) {
                time_dz = "申";
                g_time_invalid_end = my_date + " 17:00:00";
            } else if (my_time_times >= sdf.parse("17:00:00").getTime()
                    && my_time_times < sdf.parse("19:00:00").getTime()) {
                time_dz = "酉";
                g_time_invalid_end = my_date + " 19:00:00";
            } else if (my_time_times >= sdf.parse("19:00:00").getTime()
                    && my_time_times < sdf.parse("21:00:00").getTime()) {
                time_dz = "戌";
                g_time_invalid_end = my_date + " 21:00:00";
            } else if (my_time_times >= sdf.parse("21:00:00").getTime()
                    && my_time_times < sdf.parse("23:00:00").getTime()) {
                time_dz = "亥";
                g_time_invalid_end = my_date + " 23:00:00";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println("time_dz:" + time_dz + " g_time_invalid_end:" + g_time_invalid_end);

        for (int j = 1; j < 12; j++) {
            if (time_dz.trim().equals(di_zhi[j].trim())) {
                time_dz_list = j;
                break;
            }
        }

        if ((time_tg_list + time_dz_list - 1) % 10 == 0) {
            time_tg = "癸";
        } else {
            time_tg = tian_gan[(time_tg_list + time_dz_list - 1) % 10];
        }

        ZJResult zjvo = new ZJResult();
        zjvo.setDd_tg(dd_tg);
        zjvo.setTime_tg(time_tg);
        zjvo.setTime_dz(time_dz);
        zjvo.setG_time_invalid_end(g_time_invalid_end);

        return  zjvo;


    }


}
