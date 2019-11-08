package com.yyk.sz.zhzy.lzxt.xycf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.List;

/**
 *方剂实体类
 */
public class FangJiSubEntity extends BaseEntity {
    private String empBasicMainID;
    private String fangJiSubID;
    private String fangJiSubCode;
    private String fangJiSubName;
    private String effect;
    private String attend;
    private String calcite;
    private String source;
    private double UsageCount;
    private String advice;
    private String remark;
    private boolean IsDaiJian;
    private String fangJiUsage;
    private String operaType;
    List<FangJiSubEntity> fangJiDetailSubList;

    public String getOperaType() {
        return operaType;
    }

    public void setOperaType(String operaType) {
        this.operaType = operaType;
    }

    public String getFangJiSubID() {
        return fangJiSubID;
    }

    public void setFangJiSubID(String fangJiSubID) {
        this.fangJiSubID = fangJiSubID;
    }

    public String getFangJiSubCode() {
        return fangJiSubCode;
    }

    public void setFangJiSubCode(String fangJiSubCode) {
        this.fangJiSubCode = fangJiSubCode;
    }

    public String getFangJiSubName() {
        return fangJiSubName;
    }

    public void setFangJiSubName(String fangJiSubName) {
        this.fangJiSubName = fangJiSubName;
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

    public double getUsageCount() {
        return UsageCount;
    }

    public void setUsageCount(double usageCount) {
        UsageCount = usageCount;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<FangJiSubEntity> getFangJiDetailSubList() {
        return fangJiDetailSubList;
    }

    public void setFangJiDetailSubList(List<FangJiSubEntity> fangJiDetailSubList) {
        this.fangJiDetailSubList = fangJiDetailSubList;
    }

    public double getLPrice() {
        return LPrice;
    }

    public void setLPrice(double LPrice) {
        this.LPrice = LPrice;
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

    public String getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(String empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
    }

    public boolean isDaiJian() {
        return IsDaiJian;
    }

    public void setDaiJian(boolean daiJian) {
        IsDaiJian = daiJian;
    }

    public String getFangJiUsage() {
        return fangJiUsage;
    }

    public void setFangJiUsage(String fangJiUsage) {
        this.fangJiUsage = fangJiUsage;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public int getFangJiDetailSubID() {
        return fangJiDetailSubID;
    }

    public void setFangJiDetailSubID(int fangJiDetailSubID) {
        this.fangJiDetailSubID = fangJiDetailSubID;
    }

    public double getWholeMoney() {
        return wholeMoney;
    }

    public void setWholeMoney(double wholeMoney) {
        this.wholeMoney = wholeMoney;
    }

    public double getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(double quanitity) {
        this.quanitity = quanitity;
    }

    public String getSufferTypeCode() {
        return sufferTypeCode;
    }

    public void setSufferTypeCode(String sufferTypeCode) {
        this.sufferTypeCode = sufferTypeCode;
    }

    public String getDrugWayCode() {
        return drugWayCode;
    }

    public void setDrugWayCode(String drugWayCode) {
        this.drugWayCode = drugWayCode;
    }

    public String getFrequencyCode() {
        return frequencyCode;
    }

    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }

    public String getUseDays() {
        return useDays;
    }

    public void setUseDays(String useDays) {
        this.useDays = useDays;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    private String drugCode;
    private String drugName;
    private int fangJiDetailSubID;
    private double LPrice;
    private double wholeMoney;
    private double quanitity;
    private String sufferTypeCode;

    private String drugWayCode;
    private String frequencyCode;
    private String useDays;
    private String totalAmount;
    private String consumption;

    private String DrugCodeValue;//西药编码
    private String ConsumptionValue; //用量
    private String DrugWayCodeValue;//用药方式
    private String FrequencyCodeValue; //用药频率
    private String UseDaysValue; //用药天数
    private String TotalAmountValue; //总量
    private String QuanitityValue; //领量
    private String LPriceValue;	//单价
    private String WholeMoneyValue; //领量


}

