package com.yyk.sz.zhzy.lzxt.xycf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 药品列表信息
 */
public class XiYaoInfo extends BaseEntity {

    //药品编码
    private String DrugCode;
    //药品名称
    private String DrugName;
    //HIS对应编码
    private String HISCorreCode;
    //别名
    private String OtherName;
    //输入码
    private String InputCode;
    //药剂标示（0，中药；1，穴位；2，西药）
    private double DrugFlag;
    //是否停用（0,未停用；1停用）
    private boolean StopFlag;
    //用药方式编码
    private String DrugWayCode;
    //用药方式名称
    private String DrugWayName;
    //用药频次编码
    private String FrequencyCode;
    //用药频次名称
    private String FrequencyName;

    private String PinYinCode;

    private  String Coefficient;

    private int EmpBasicMainID;

    private String FangJiSubID;

    private String FangJiSubCode;

    private String FangJiSubName;

    private String billCode;
    private String dateString;
    private String itemCode;
    private int option;
    private String voucherCode;
    private  String v_GetBillCode;
    private  int v_GetBillID;
    private String proUUID;


    public String getProUUID() {
        return proUUID;
    }

    public void setProUUID(String proUUID) {
        this.proUUID = proUUID;
    }



    public String getPinYinCode() {
        return PinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        PinYinCode = pinYinCode;
    }

    public String getCoefficient() {
        return Coefficient;
    }

    public void setCoefficient(String coefficient) {
        Coefficient = coefficient;
    }

    public String getV_GetBillCode() {
        return v_GetBillCode;
    }

    public void setV_GetBillCode(String v_GetBillCode) {
        this.v_GetBillCode = v_GetBillCode;
    }

    public int getV_GetBillID() {
        return v_GetBillID;
    }

    public void setV_GetBillID(int v_GetBillID) {
        this.v_GetBillID = v_GetBillID;
    }

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
    }

    public String getDrugName() {
        return DrugName;
    }

    public void setDrugName(String drugName) {
        DrugName = drugName;
    }

    public String getHISCorreCode() {
        return HISCorreCode;
    }

    public void setHISCorreCode(String HISCorreCode) {
        this.HISCorreCode = HISCorreCode;
    }

    public String getOtherName() {
        return OtherName;
    }

    public void setOtherName(String otherName) {
        OtherName = otherName;
    }

    public String getInputCode() {
        return InputCode;
    }

    public void setInputCode(String inputCode) {
        InputCode = inputCode;
    }

    public double getDrugFlag() {
        return DrugFlag;
    }

    public void setDrugFlag(double drugFlag) {
        DrugFlag = drugFlag;
    }

    public boolean isStopFlag() {
        return StopFlag;
    }

    public void setStopFlag(boolean stopFlag) {
        StopFlag = stopFlag;
    }

    public String getDrugWayCode() {
        return DrugWayCode;
    }

    public void setDrugWayCode(String drugWayCode) {
        DrugWayCode = drugWayCode;
    }

    public String getDrugWayName() {
        return DrugWayName;
    }

    public void setDrugWayName(String drugWayName) {
        DrugWayName = drugWayName;
    }

    public String getFrequencyCode() {
        return FrequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        FrequencyCode = frequencyCode;
    }

    public String getFrequencyName() {
        return FrequencyName;
    }

    public void setFrequencyName(String frequencyName) {
        FrequencyName = frequencyName;
    }

    public int getEmpBasicMainID() {
        return EmpBasicMainID;
    }

    public void setEmpBasicMainID(int empBasicMainID) {
        EmpBasicMainID = empBasicMainID;
    }

    public String getFangJiSubID() {
        return FangJiSubID;
    }

    public void setFangJiSubID(String fangJiSubID) {
        FangJiSubID = fangJiSubID;
    }

    public String getFangJiSubCode() {
        return FangJiSubCode;
    }

    public void setFangJiSubCode(String fangJiSubCode) {
        FangJiSubCode = fangJiSubCode;
    }

    public String getFangJiSubName() {
        return FangJiSubName;
    }

    public void setFangJiSubName(String fangJiSubName) {
        FangJiSubName = fangJiSubName;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }
}

