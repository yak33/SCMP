package com.yyk.sz.zhzy.lzxt.zjkf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.List;

/**
 * 完成就诊或保存
 */
public class SaveOrFinishVisit extends BaseEntity {

    /**
     * 病人门诊ID
     */
    private Integer empBasicMainID;
    /**
     * 方剂编码
     */
    private String fangJiSubCode;
    /**
     * 方剂名称
     */
    private String fangJiSubName;
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
     * 付数
     */
    private Integer usageCount;
    /**
     * 医嘱
     */
    private String advice;
    /**
     * 备注
     */
    private String remark;
    /**
     * 中药是否代煎中药
     */
    private boolean IsDaiJian;
    /**
     * 服法
     */
    private String fangjiUsage;
    /**
     * 是否针灸方（0中药方、1针灸方、2西药中成药、3手法治疗）
     */
    private Integer drugFlag;
    /**
     * 症型编码
     */
    private String dialecticalCode;
    /**
     * 治则编码
     */
    private String cureCode;
    /**
     * 中医病名编码
     */
    private String chineseMedicineCode;
    /**
     * 西医病名编码
     */
    private String westernMedicineCode;
    /**
     * 治疗状态
     */
    private String treatmentState;
    /**
     * 挂号流水号
     */
    private String registrationNum;
    /**
     * 保存or完成就诊的标记(0==保存，1==完成就诊)
     */
    private String flag;

    private String drugCode;
    private double quanitity;
    private Integer detailMinutes;
    private Integer fangJiSubID;
    private double LPrice;
    private double wholeMoney;
    private String drugName;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    /**
     * 保存草药的list集合
     */
    private List<SaveOrFinishVisit> fangJiDetailList;

    public Integer getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(Integer empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
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

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
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

    public boolean isDaiJian() {
        return IsDaiJian;
    }

    public void setDaiJian(boolean daiJian) {
        IsDaiJian = daiJian;
    }

    public String getFangjiUsage() {
        return fangjiUsage;
    }

    public void setFangjiUsage(String fangjiUsage) {
        this.fangjiUsage = fangjiUsage;
    }

    public Integer getDrugFlag() {
        return drugFlag;
    }

    public void setDrugFlag(Integer drugFlag) {
        this.drugFlag = drugFlag;
    }

    public String getDialecticalCode() {
        return dialecticalCode;
    }

    public void setDialecticalCode(String dialecticalCode) {
        this.dialecticalCode = dialecticalCode;
    }

    public String getCureCode() {
        return cureCode;
    }

    public void setCureCode(String cureCode) {
        this.cureCode = cureCode;
    }

    public String getChineseMedicineCode() {
        return chineseMedicineCode;
    }

    public void setChineseMedicineCode(String chineseMedicineCode) {
        this.chineseMedicineCode = chineseMedicineCode;
    }

    public String getWesternMedicineCode() {
        return westernMedicineCode;
    }

    public void setWesternMedicineCode(String westernMedicineCode) {
        this.westernMedicineCode = westernMedicineCode;
    }

    public String getTreatmentState() {
        return treatmentState;
    }

    public void setTreatmentState(String treatmentState) {
        this.treatmentState = treatmentState;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public double getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(double quanitity) {
        this.quanitity = quanitity;
    }

    public Integer getDetailMinutes() {
        return detailMinutes;
    }

    public void setDetailMinutes(Integer detailMinutes) {
        this.detailMinutes = detailMinutes;
    }

    public Integer getFangJiSubID() {
        return fangJiSubID;
    }

    public void setFangJiSubID(Integer fangJiSubID) {
        this.fangJiSubID = fangJiSubID;
    }

    public double getLPrice() {
        return LPrice;
    }

    public void setLPrice(double LPrice) {
        this.LPrice = LPrice;
    }

    public double getWholeMoney() {
        return wholeMoney;
    }

    public void setWholeMoney(double wholeMoney) {
        this.wholeMoney = wholeMoney;
    }

    public List<SaveOrFinishVisit> getFangJiDetailList() {
        return fangJiDetailList;
    }

    public void setFangJiDetailList(List<SaveOrFinishVisit> fangJiDetailList) {
        this.fangJiDetailList = fangJiDetailList;
    }
}
