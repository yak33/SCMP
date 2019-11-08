package com.yyk.sz.zhzy.lzxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 *
 */
public class GRListRst extends BaseEntity {

    private String UUID;
    private String chineseMedicineCode;
    private String chineseMedicineName;
    private String cureCode;
    private String cureName;
    private String dialecticalCode;
    private String dialecticalName;
    private String prescriptionCode;
    private String prescriptionName;
    private String score;
    private String subID;
    private String westernMedicineCode;
    private String westernMedicineName;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
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

    public String getCureCode() {
        return cureCode;
    }

    public void setCureCode(String cureCode) {
        this.cureCode = cureCode;
    }

    public String getCureName() {
        return cureName;
    }

    public void setCureName(String cureName) {
        this.cureName = cureName;
    }

    public String getDialecticalCode() {
        return dialecticalCode;
    }

    public void setDialecticalCode(String dialecticalCode) {
        this.dialecticalCode = dialecticalCode;
    }

    public String getDialecticalName() {
        return dialecticalName;
    }

    public void setDialecticalName(String dialecticalName) {
        this.dialecticalName = dialecticalName;
    }

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
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
}