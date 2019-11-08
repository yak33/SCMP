package com.yyk.sz.common.mybatis.util;

import java.util.UUID;

/**
 * 自动生成32位的UUid
 * @Author: ZhangChao
 * @Date: 2018/12/12 9:45
 * @Version: 1.0
 */
public class UUIDUtil {

    public static String getUUID() {


        return UUID.randomUUID().toString().replace("-", "");
    }

}
