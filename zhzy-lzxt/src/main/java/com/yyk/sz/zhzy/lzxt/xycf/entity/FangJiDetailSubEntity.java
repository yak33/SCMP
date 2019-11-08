package com.yyk.sz.zhzy.lzxt.xycf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 *方剂实体类
 */
public class FangJiDetailSubEntity extends BaseEntity {
    private String DrugCode;
    private String FangJiSubID;
    private int FangJiDetailSubID;
    private double LPrice;
    private double WholeMoney;
    private double Quanitity;
    private String SufferTypeCode;
    private String Remark;

    private String DrugWayCode;
    private String FrequencyCode;
    private String UseDays;
    private String TotalAmount;
    private String Consumption;

    private String DrugCodeValue;//西药编码
    private String ConsumptionValue; //用量
    private String DrugWayCodeValue;//用药方式
    private String FrequencyCodeValue; //用药频率
    private String UseDaysValue; //用药天数
    private String TotalAmountValue; //总量
    private String QuanitityValue; //领量
    private String LPriceValue;	//单价
    private String WholeMoneyValue; //领量

    private String FangJiSubCode;
    private String EmpBasicMainID;

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
    }

    public String getFangJiSubID() {
        return FangJiSubID;
    }

    public void setFangJiSubID(String fangJiSubID) {
        FangJiSubID = fangJiSubID;
    }

    public int getFangJiDetailSubID() {
        return FangJiDetailSubID;
    }

    public void setFangJiDetailSubID(int fangJiDetailSubID) {
        FangJiDetailSubID = fangJiDetailSubID;
    }

    public double getLPrice() {
        return LPrice;
    }

    public void setLPrice(double LPrice) {
        this.LPrice = LPrice;
    }

    public double getWholeMoney() {
        return WholeMoney;
    }

    public void setWholeMoney(double wholeMoney) {
        WholeMoney = wholeMoney;
    }

    public double getQuanitity() {
        return Quanitity;
    }

    public void setQuanitity(double quanitity) {
        Quanitity = quanitity;
    }

    public String getSufferTypeCode() {
        return SufferTypeCode;
    }

    public void setSufferTypeCode(String sufferTypeCode) {
        SufferTypeCode = sufferTypeCode;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getDrugWayCode() {
        return DrugWayCode;
    }

    public void setDrugWayCode(String drugWayCode) {
        DrugWayCode = drugWayCode;
    }

    public String getFrequencyCode() {
        return FrequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        FrequencyCode = frequencyCode;
    }

    public String getUseDays() {
        return UseDays;
    }

    public void setUseDays(String useDays) {
        UseDays = useDays;
    }

    public String getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        TotalAmount = totalAmount;
    }

    public String getConsumption() {
        return Consumption;
    }

    public void setConsumption(String consumption) {
        Consumption = consumption;
    }

    public String getDrugCodeValue() {
        return DrugCodeValue;
    }

    public void setDrugCodeValue(String drugCodeValue) {
        DrugCodeValue = drugCodeValue;
    }

    public String getConsumptionValue() {
        return ConsumptionValue;
    }

    public void setConsumptionValue(String consumptionValue) {
        ConsumptionValue = consumptionValue;
    }

    public String getDrugWayCodeValue() {
        return DrugWayCodeValue;
    }

    public void setDrugWayCodeValue(String drugWayCodeValue) {
        DrugWayCodeValue = drugWayCodeValue;
    }

    public String getFrequencyCodeValue() {
        return FrequencyCodeValue;
    }

    public void setFrequencyCodeValue(String frequencyCodeValue) {
        FrequencyCodeValue = frequencyCodeValue;
    }

    public String getUseDaysValue() {
        return UseDaysValue;
    }

    public void setUseDaysValue(String useDaysValue) {
        UseDaysValue = useDaysValue;
    }

    public String getTotalAmountValue() {
        return TotalAmountValue;
    }

    public void setTotalAmountValue(String totalAmountValue) {
        TotalAmountValue = totalAmountValue;
    }

    public String getQuanitityValue() {
        return QuanitityValue;
    }

    public void setQuanitityValue(String quanitityValue) {
        QuanitityValue = quanitityValue;
    }

    public String getLPriceValue() {
        return LPriceValue;
    }

    public void setLPriceValue(String LPriceValue) {
        this.LPriceValue = LPriceValue;
    }

    public String getWholeMoneyValue() {
        return WholeMoneyValue;
    }

    public void setWholeMoneyValue(String wholeMoneyValue) {
        WholeMoneyValue = wholeMoneyValue;
    }

    public String getFangJiSubCode() {
        return FangJiSubCode;
    }

    public void setFangJiSubCode(String fangJiSubCode) {
        FangJiSubCode = fangJiSubCode;
    }

    public String getEmpBasicMainID() {
        return EmpBasicMainID;
    }

    public void setEmpBasicMainID(String empBasicMainID) {
        EmpBasicMainID = empBasicMainID;
    }
}

