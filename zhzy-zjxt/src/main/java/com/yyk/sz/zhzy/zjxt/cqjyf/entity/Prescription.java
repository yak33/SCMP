package com.yyk.sz.zhzy.zjxt.cqjyf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.List;

/**
 * 存取经验方
 * @Author: ZhangChao
 * @Date: 2018/11/23 16:12
 * @Version: 1.0
 */
public class Prescription extends BaseEntity {

    /**
     * 方剂编码
     */
    private String prescriptionCode;
    /**
     * 方剂名称
     */
    private String prescriptionName;
    /**
     * 拼音码
     */
    private String pinYinCode;
    /**
     * 功效
     */
    private String effect;
    /**
     * 主治
     */
    private String attend;
    /**
     * 方解
     */
    private String calcite;
    /**
     * 来源
     */
    private String source;
    /**
     * 备注
     */
    private String remark;
    private String userCode;
    private String drugFlag;

    private double quanitity;
    /**
     * 中药编码
     */
    private int drugCode;
    private String PCCode;
    private boolean personalFlag;

    private String makeDate;
    private String searchText;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
    }

    /**
     * 方剂包含的草药list
     */
    private List<Prescription> subList;
    private boolean sysFlag;

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public String getCalcite() {
        return calcite;
    }

    public void setCalcite(String calcite) {
        this.calcite = calcite;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDrugFlag() {
        return drugFlag;
    }

    public void setDrugFlag(String drugFlag) {
        this.drugFlag = drugFlag;
    }

    public double getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(double quanitity) {
        this.quanitity = quanitity;
    }

    public int getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(int drugCode) {
        this.drugCode = drugCode;
    }

    public boolean isPersonalFlag() {
        return personalFlag;
    }

    public void setPersonalFlag(boolean personalFlag) {
        this.personalFlag = personalFlag;
    }

    public String getPCCode() {
        return PCCode;
    }

    public void setPCCode(String PCCode) {
        this.PCCode = PCCode;
    }

    public List<Prescription> getSubList() {
        return subList;
    }

    public void setSubList(List<Prescription> subList) {
        this.subList = subList;
    }

    public boolean isSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(boolean sysFlag) {
        this.sysFlag = sysFlag;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
