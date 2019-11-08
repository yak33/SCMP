package com.yyk.sz.zhzy.zjxt.wcjz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.List;

/**
 * 保存或完成就诊--针灸
 * @Author: ZhangChao
 * @Date: 2018/12/4 11:11
 * @Version: 1.0
 */
public class SaveOrFinishZJ extends BaseEntity {

    private String empBasicMainID;
    private String prescriptionCode; //FangJiSubCode
    private String prescriptionName; //FangJiSubName
    private String dialecticalCode;
    private String cureCode;
    private String effect; //Calcite
    private String attend;
    private String calcite;
    private String source;
    private String chineseMedicineCode;
    private String westernMedicineCode;
    private String treatmentState;
    private Integer fangJiSubID; //detail表插入时用
    private String acupointCode; //drugCode
    private String acupointName;
    private double quanitity;
    private double LPrice;
    private double wholeMoney;
    private Integer detailMinutes;
    private String registrationNum;
    private Integer zjMinutes; //留针时间
    private String beginDate; //至有效时间
    private String flag;//保存还是完成
    /**
     * 保存穴位的list集合
     */
    private List<SaveOrFinishZJ> fangJiDetailList;

    public String getAcupointName() {
        return acupointName;
    }

    public void setAcupointName(String acupointName) {
        this.acupointName = acupointName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public Integer getZjMinutes() {
        return zjMinutes;
    }

    public void setZjMinutes(Integer zjMinutes) {
        this.zjMinutes = zjMinutes;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEmpBasicMainID() {
        return empBasicMainID;
    }

    public void setEmpBasicMainID(String empBasicMainID) {
        this.empBasicMainID = empBasicMainID;
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

    public Integer getFangJiSubID() {
        return fangJiSubID;
    }

    public void setFangJiSubID(Integer fangJiSubID) {
        this.fangJiSubID = fangJiSubID;
    }

    public String getAcupointCode() {
        return acupointCode;
    }

    public void setAcupointCode(String acupointCode) {
        this.acupointCode = acupointCode;
    }

    public double getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(double quanitity) {
        this.quanitity = quanitity;
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

    public Integer getDetailMinutes() {
        return detailMinutes;
    }

    public void setDetailMinutes(Integer detailMinutes) {
        this.detailMinutes = detailMinutes;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public List<SaveOrFinishZJ> getFangJiDetailList() {
        return fangJiDetailList;
    }

    public void setFangJiDetailList(List<SaveOrFinishZJ> fangJiDetailList) {
        this.fangJiDetailList = fangJiDetailList;
    }
}
