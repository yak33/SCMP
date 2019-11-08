package com.yyk.sz.zhzy.gcxt.xybm.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 西医病名
 */
public class GCWesternMedicine extends BaseEntity {
    /**
     * 西医病名
     */
    private String WesternMedicineName;

    /**
     * 西医病名
     */
    private String WesternMedicineCode;

    /**
     * 拼音码
     */
    private String PinYinCode;

    private String SystemCode;

    public String getWesternMedicineName() {
        return WesternMedicineName;
    }

    public void setWesternMedicineName(String westernMedicineName) {
        WesternMedicineName = westernMedicineName;
    }

    public String getWesternMedicineCode() {
        return WesternMedicineCode;
    }

    public void setWesternMedicineCode(String westernMedicineCode) {
        WesternMedicineCode = westernMedicineCode;
    }

    public String getPinYinCode() {
        return PinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        PinYinCode = pinYinCode;
    }

    public String getSystemCode() {
        return SystemCode;
    }

    public void setSystemCode(String systemCode) {
        SystemCode = systemCode;
    }
}
