package com.yyk.sz.common.base.result;

import java.io.Serializable;

/**
 * Created by zhaofs on 2017/3/22
 * 业务异常code前缀定义规范：
 * 5000 共同模块
 * 5100 模块1
 * 5200 模块2
 * 5300 模块3
 * 依次类推
 */
public interface CodeMsgAble extends Serializable {
    //操作成功共通部分
    String SUCCESS_C = "0";
    String SUCCESS_M = "操作成功";

    default String getCode() {
        return SUCCESS_C;
    }

    default String getMsg() {
        return SUCCESS_M;
    }
}
