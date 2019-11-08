package com.yyk.sz.zhzy.zjxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 主证，兼症等
 */
public class MainSymptomZJ extends BaseEntity {
    /**
     * 主症编码
     */
    private int mainSymptomCode;

    /**
     * 主症名称
     */
    private String mainSymptomName;

    /**
     * 拼音码
     */
    private String pinYinCode;

    /**
     * 主症分类名称
     */
    private String mainSymptomTypeName;

    private int mainSymptomTypeCode;
    /**
     * 分值
     */
    private String soue;

    /**
     * 科室编码
     */
    private String deptCode;
    /**
     * 兼症编码
     */
    private int diseaseCode;
    /**
     * 兼症名称
     */
    private String diseaseName;

    private String selDisease;
    /**
     * 舌像编码
     */
    private int tongueCode;

    /**
     * 舌像名称
     */
    private String tongueName;

    private String selTongue;

    private String tongueImage;
    /**
     * 脉象编码
     */
    private int pulseCode;

    /**
     * 脉象名称
     */
    private String pulseName;

    private String selPulse;

    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getMainSymptomCode() {
        return mainSymptomCode;
    }

    public void setMainSymptomCode(int mainSymptomCode) {
        this.mainSymptomCode = mainSymptomCode;
    }

    public String getMainSymptomName() {
        return mainSymptomName;
    }

    public void setMainSymptomName(String mainSymptomName) {
        this.mainSymptomName = mainSymptomName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getMainSymptomTypeName() {
        return mainSymptomTypeName;
    }

    public void setMainSymptomTypeName(String mainSymptomTypeName) {
        this.mainSymptomTypeName = mainSymptomTypeName;
    }

    public int getMainSymptomTypeCode() {
        return mainSymptomTypeCode;
    }

    public void setMainSymptomTypeCode(int mainSymptomTypeCode) {
        this.mainSymptomTypeCode = mainSymptomTypeCode;
    }

    public String getSoue() {
        return soue;
    }

    public void setSoue(String soue) {
        this.soue = soue;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public int getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(int diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getSelDisease() {
        return selDisease;
    }

    public void setSelDisease(String selDisease) {
        this.selDisease = selDisease;
    }

    public int getTongueCode() {
        return tongueCode;
    }

    public void setTongueCode(int tongueCode) {
        this.tongueCode = tongueCode;
    }

    public String getTongueName() {
        return tongueName;
    }

    public void setTongueName(String tongueName) {
        this.tongueName = tongueName;
    }

    public String getSelTongue() {
        return selTongue;
    }

    public void setSelTongue(String selTongue) {
        this.selTongue = selTongue;
    }

    public String getTongueImage() {
        return tongueImage;
    }

    public void setTongueImage(String tongueImage) {
        this.tongueImage = tongueImage;
    }

    public int getPulseCode() {
        return pulseCode;
    }

    public void setPulseCode(int pulseCode) {
        this.pulseCode = pulseCode;
    }

    public String getPulseName() {
        return pulseName;
    }

    public void setPulseName(String pulseName) {
        this.pulseName = pulseName;
    }

    public String getSelPulse() {
        return selPulse;
    }

    public void setSelPulse(String selPulse) {
        this.selPulse = selPulse;
    }
}
