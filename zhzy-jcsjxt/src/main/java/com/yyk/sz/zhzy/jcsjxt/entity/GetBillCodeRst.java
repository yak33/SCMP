package com.yyk.sz.zhzy.jcsjxt.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 存储过程：gy_sp_getidcode_test 的运行结果
 */
public class GetBillCodeRst extends BaseEntity {

    //
    private String UUID;
    //
    private String GetBillCode;
    //
    private String GetBillId;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getGetBillCode() {
        return GetBillCode;
    }

    public void setGetBillCode(String getBillCode) {
        GetBillCode = getBillCode;
    }

    public String getGetBillId() {
        return GetBillId;
    }

    public void setGetBillId(String getBillId) {
        GetBillId = getBillId;
    }

}

