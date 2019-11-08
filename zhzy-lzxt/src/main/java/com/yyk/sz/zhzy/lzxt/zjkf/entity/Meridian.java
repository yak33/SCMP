package com.yyk.sz.zhzy.lzxt.zjkf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 归经
 */
public class Meridian extends BaseEntity {
    /**
     * 草药编码
     */
    private String DrugCode;
    /**
     * 归经编码
     */
    private String MeridianCode;
    /**
     * 归经名称
     */
    private String MeridianName;

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
    }

    public String getMeridianCode() {
        return MeridianCode;
    }

    public void setMeridianCode(String meridianCode) {
        MeridianCode = meridianCode;
    }

    public String getMeridianName() {
        return MeridianName;
    }

    public void setMeridianName(String meridianName) {
        MeridianName = meridianName;
    }
}
