package com.yyk.sz.zhzy.lzxt.bcbl.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class EmpBasicInfoRst extends BaseEntity {

    private String UUID;

    //
    private String ReturnValueStr;


    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getReturnValueStr() {
        return ReturnValueStr;
    }

    public void setReturnValueStr(String returnValueStr) {
        ReturnValueStr = returnValueStr;
    }

}
