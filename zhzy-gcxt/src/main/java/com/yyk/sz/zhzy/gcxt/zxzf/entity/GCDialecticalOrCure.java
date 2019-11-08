package com.yyk.sz.zhzy.gcxt.zxzf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 症型治法
 */
public class GCDialecticalOrCure extends BaseEntity {

    /**
     * 中医病名名称
     */
    private String ChineseMedicineName;

    /**
     * 中医病名编码
     */
    private String ChineseMedicineCode;


    /**
     * 治则名称
     */
    private String CureName;

    /**
     * 主症编码
     */
    private String MainSymptomCode;

    /**
     * 治则拼音码
     */
    private String CurePinYinCode;

    /**
     * 症型拼音码
     */
    private String DialecticalPinYinCode;

    /**
     * 症型名称
     */
    private String DialecticalName;

    /**
     * 主症名称
     */
    private String MainSymptomName;

    /**
     * 西医病名
     */
    private String WesternMedicineName;

    private String CureCode;
    private String DialecticalCode;

    public String getCureCode() {
        return CureCode;
    }

    public void setCureCode(String cureCode) {
        CureCode = cureCode;
    }

    public String getDialecticalCode() {
        return DialecticalCode;
    }

    public void setDialecticalCode(String dialecticalCode) {
        DialecticalCode = dialecticalCode;
    }

    public String getChineseMedicineName() {
        return ChineseMedicineName;
    }

    public void setChineseMedicineName(String chineseMedicineName) {
        ChineseMedicineName = chineseMedicineName;
    }

    public String getCureName() {
        return CureName;
    }

    public void setCureName(String cureName) {
        CureName = cureName;
    }

    public String getMainSymptomCode() {
        return MainSymptomCode;
    }

    public void setMainSymptomCode(String mainSymptomCode) {
        MainSymptomCode = mainSymptomCode;
    }

    public String getCurePinYinCode() {
        return CurePinYinCode;
    }

    public void setCurePinYinCode(String curePinYinCode) {
        CurePinYinCode = curePinYinCode;
    }

    public String getDialecticalPinYinCode() {
        return DialecticalPinYinCode;
    }

    public void setDialecticalPinYinCode(String dialecticalPinYinCode) {
        DialecticalPinYinCode = dialecticalPinYinCode;
    }

    public String getDialecticalName() {
        return DialecticalName;
    }

    public void setDialecticalName(String dialecticalName) {
        DialecticalName = dialecticalName;
    }

    public String getMainSymptomName() {
        return MainSymptomName;
    }

    public void setMainSymptomName(String mainSymptomName) {
        MainSymptomName = mainSymptomName;
    }

    public String getWesternMedicineName() {
        return WesternMedicineName;
    }

    public void setWesternMedicineName(String westernMedicineName) {
        WesternMedicineName = westernMedicineName;
    }

    public String getChineseMedicineCode() {
        return ChineseMedicineCode;
    }

    public void setChineseMedicineCode(String chineseMedicineCode) {
        ChineseMedicineCode = chineseMedicineCode;
    }
}
