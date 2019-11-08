package com.yyk.sz.zhzy.lzxt.zjkf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 草药字典
 */
public class DrugDict extends BaseEntity {
    /**
     * 草药编码
     */
    private String DrugCode;
    /**
     * 别名
     */
    private String OtherName;
    /**
     * 来源
     */
    private String DrugSource;
    /**
     * 功能
     */
    private String DrugFunction;
    /**
     * 主治
     */
    private String DrugAttend;
    /**
     * 用法用量
     */
    private String USAGEE;
    /**
     * 特殊用法
     */
    private String SpecialUsage;
    /**
     * 注意事项
     */
    private String MatterAttend;
    /**
     * 贮藏
     */
    private String DrugStorage;

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
    }

    public String getOtherName() {
        return OtherName;
    }

    public void setOtherName(String otherName) {
        OtherName = otherName;
    }

    public String getDrugSource() {
        return DrugSource;
    }

    public void setDrugSource(String drugSource) {
        DrugSource = drugSource;
    }

    public String getDrugFunction() {
        return DrugFunction;
    }

    public void setDrugFunction(String drugFunction) {
        DrugFunction = drugFunction;
    }

    public String getDrugAttend() {
        return DrugAttend;
    }

    public void setDrugAttend(String drugAttend) {
        DrugAttend = drugAttend;
    }

    public String getUSAGEE() {
        return USAGEE;
    }

    public void setUSAGEE(String USAGEE) {
        this.USAGEE = USAGEE;
    }

    public String getSpecialUsage() {
        return SpecialUsage;
    }

    public void setSpecialUsage(String specialUsage) {
        SpecialUsage = specialUsage;
    }

    public String getMatterAttend() {
        return MatterAttend;
    }

    public void setMatterAttend(String matterAttend) {
        MatterAttend = matterAttend;
    }

    public String getDrugStorage() {
        return DrugStorage;
    }

    public void setDrugStorage(String drugStorage) {
        DrugStorage = drugStorage;
    }
}
