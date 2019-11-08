package com.yyk.sz.zhzy.zjxt.zxzf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 论治结果
 * @Author: ZhangChao
 * @Date: 2018/12/1 10:43
 * @Version: 1.0
 */
public class GovernanceResultZJ extends BaseEntity {
    /**
     * 病人门诊ID
     */
    private Integer empBasicMainID;
    /**
     * 辩证论治类型OperationType=1辩证论治、2直接开方
     */
    private Integer operationType;
    /**
     * 症型编码
     */
    private String dialecticalCode;
    /**
     * 治则编码
     */
    private String cureCode;
    /**
     * 方剂编码
     */
    private String prescriptionCode;
    /**
     * 方剂名称
     */
    private String prescriptionName;
    /**
     * 中药编码
     */
    private String drugCode;
    private String drugCodeStr;
    private String dialecticalName;
    private String chineseMedicineCode;
    private String chineseMedicineName;
    private String westernMedicineCode;
    private String westernMedicineName;
    private String subID;
    private String cureName;
    private String score;
    private String proUUID;

    public String getProUUID() {
        return proUUID;
    }

    public void setProUUID(String proUUID) {
        this.proUUID = proUUID;
    }


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDialecticalName() {
        return dialecticalName;
    }

    public void setDialecticalName(String dialecticalName) {
        this.dialecticalName = dialecticalName;
    }

    public String getChineseMedicineCode() {
        return chineseMedicineCode;
    }

    public void setChineseMedicineCode(String chineseMedicineCode) {
        this.chineseMedicineCode = chineseMedicineCode;
    }

    public String getChineseMedicineName() {
        return chineseMedicineName;
    }

    public void setChineseMedicineName(String chineseMedicineName) {
        this.chineseMedicineName = chineseMedicineName;
    }

    public String getWesternMedicineCode() {
        return westernMedicineCode;
    }

    public void setWesternMedicineCode(String westernMedicineCode) {
        this.westernMedicineCode = westernMedicineCode;
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

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public Integer getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(Integer empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
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

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public String getDrugCodeStr() {
        return drugCodeStr;
    }

    public void setDrugCodeStr(String drugCodeStr) {
        this.drugCodeStr = drugCodeStr;
    }
}
