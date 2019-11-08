package com.yyk.sz.zhzy.lzxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 论治结果
 * @Author: ZhangChao
 * @Date: 2018-11-13 10:17
 * ---(变量名还是用驼峰命名法吧，跟类名似的一直首字母大写感觉很不规范)
 */
public class GovernanceResult extends BaseEntity {
    /**
     * 病人门诊ID
     */
    private int empBasicMainID;
    /**
     * 辩证论治类型OperationType=1辩证论治、2直接开方
     */
    private int operationType;
    /**
     * 症型编码
     */
    private String dialecticalCode;
    private String dialecticalName;
    private String chineseMedicineCode;
    private String chineseMedicineName;
    private String westernMedicineCode;
    private String westernMedicineName;
    private String subID;
    /**
     * 治则编码
     */
    private String cureCode;
    private String cureName;
    /**
     * 方剂编码
     */
    private String prescriptionCode;
    /**
     * 中药编码
     */
    private int drugCode;

    private String drugCodeStr;

    private String proUUID;

    public String getProUUID() {
        return proUUID;
    }

    public void setProUUID(String proUUID) {
        this.proUUID = proUUID;
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

    public String getDialecticalName() {
        return dialecticalName;
    }

    public void setDialecticalName(String dialecticalName) {
        this.dialecticalName = dialecticalName;
    }

    public String getChineseMedicineName() {
        return chineseMedicineName;
    }

    public void setChineseMedicineName(String chineseMedicineName) {
        this.chineseMedicineName = chineseMedicineName;
    }

    public String getWesternMedicineName() {
        return westernMedicineName;
    }

    public void setWesternMedicineName(String westernMedicineName) {
        this.westernMedicineName = westernMedicineName;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getCureName() {
        return cureName;
    }

    public void setCureName(String cureName) {
        this.cureName = cureName;
    }

    public String getDrugCodeStr() {
        return drugCodeStr;
    }

    public void setDrugCodeStr(String drugCodeStr) {
        this.drugCodeStr = drugCodeStr;
    }

    /**
     * 子表ID
     */
    private int prescriptionSubID;
    /**
     * 药量
     */
    private BigDecimal quanitity;
    /**
     * 煎熬方法编码
     */
    private String sufferTypeCode;
    /**
     * 君药
     */
    private String JFlag;
    /**
     * 臣药
     */
    private String CFlag;
    /**
     * 左药
     */
    private String ZFlag;
    /**
     * 史药
     */
    private String SFlag;
    /**
     * 备注
     */
    private String remark;

    private String drugName;
    private String unitName;
    private String sufferTypeName;
    private String MinutesValue;
    private String prescriptionName;
    private String calcite;
    private String source;
    private String effect;
    private String attend;
    private String TasteScore;
    private String DrugTaste;

    public String getDrugTaste() {
        return DrugTaste;
    }

    public void setDrugTaste(String drugTaste) {
        DrugTaste = drugTaste;
    }

    public String getTasteScore() {
        return TasteScore;
    }

    public void setTasteScore(String tasteScore) {
        TasteScore = tasteScore;
    }

    /**
     * 归经编码
     */
    private String meridianCode;
    /**
     * 归经名称
     */
    private String meridianName;
    /**
     * 针灸标识
     */
    private String ZJFlag;
    /**
     * 分值
     */
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMeridianCode() {
        return meridianCode;
    }

    public void setMeridianCode(String meridianCode) {
        this.meridianCode = meridianCode;
    }

    public String getMeridianName() {
        return meridianName;
    }

    public void setMeridianName(String meridianName) {
        this.meridianName = meridianName;
    }

    public String getZJFlag() {
        return ZJFlag;
    }

    public void setZJFlag(String ZJFlag) {
        this.ZJFlag = ZJFlag;
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

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public int getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(int drugCode) {
        this.drugCode = drugCode;
    }

    public int getPrescriptionSubID() {
        return prescriptionSubID;
    }

    public void setPrescriptionSubID(int prescriptionSubID) {
        this.prescriptionSubID = prescriptionSubID;
    }

    public BigDecimal getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(BigDecimal quanitity) {
        this.quanitity = quanitity;
    }

    public String getSufferTypeCode() {
        return sufferTypeCode;
    }

    public void setSufferTypeCode(String sufferTypeCode) {
        this.sufferTypeCode = sufferTypeCode;
    }

    public String getJFlag() {
        return JFlag;
    }

    public void setJFlag(String JFlag) {
        this.JFlag = JFlag;
    }

    public String getCFlag() {
        return CFlag;
    }

    public void setCFlag(String CFlag) {
        this.CFlag = CFlag;
    }

    public String getZFlag() {
        return ZFlag;
    }

    public void setZFlag(String ZFlag) {
        this.ZFlag = ZFlag;
    }

    public String getSFlag() {
        return SFlag;
    }

    public void setSFlag(String SFlag) {
        this.SFlag = SFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSufferTypeName() {
        return sufferTypeName;
    }

    public void setSufferTypeName(String sufferTypeName) {
        this.sufferTypeName = sufferTypeName;
    }

    public String getMinutesValue() {
        return MinutesValue;
    }

    public void setMinutesValue(String minutesValue) {
        MinutesValue = minutesValue;
    }

    public int getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(int empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
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
}