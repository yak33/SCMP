package com.yyk.sz.common.base.utils;

import java.util.UUID;

/**
 * Created by xujiashuai on 2016/6/18.
 */
public class UtilUuid {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(uuid());
    }
}
