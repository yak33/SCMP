package com.yyk.sz.zhzy.lzxt.qjyf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

import java.util.Date;

public class GetPrescription extends BaseEntity {

    /**
     * 方剂编码
     */
    private String PrescriptionCode;
    /**
     * 方剂名称
     */
    private String PrescriptionName;
    /**
     * 拼音码
     */
    private String PinYinCode;
    /**
     * 功效
     */
    private String Effect;
    /**
     * 主治
     */
    private String Attend;
    /**
     * 方解
     */
    private String Calcite;
    /**
     * 来源
     */
    private String Source;
    /**
     * 君药比例
     */
    private String JRate;
    /**
     * 臣药比例
     */
    private String CRate;
    /**
     * 左药比例
     */
    private String ZRate;
    /**
     * 史药比例
     */
    private String SRate;
    /**
     * 备注
     */
    private String Remark;
    private String MakeName;
    private String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDrugFlag() {
        return drugFlag;
    }

    public void setDrugFlag(String drugFlag) {
        this.drugFlag = drugFlag;
    }

    private String drugFlag;

    public String getMakeName() {
        return MakeName;
    }

    public void setMakeName(String makeName) {
        MakeName = makeName;
    }

    public String getPrescriptionCode() {
        return PrescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        PrescriptionCode = prescriptionCode;
    }

    public String getPrescriptionName() {
        return PrescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        PrescriptionName = prescriptionName;
    }

    public String getPinYinCode() {
        return PinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        PinYinCode = pinYinCode;
    }

    public String getEffect() {
        return Effect;
    }

    public void setEffect(String effect) {
        Effect = effect;
    }

    public String getAttend() {
        return Attend;
    }

    public void setAttend(String attend) {
        Attend = attend;
    }

    public String getCalcite() {
        return Calcite;
    }

    public void setCalcite(String calcite) {
        Calcite = calcite;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getJRate() {
        return JRate;
    }

    public void setJRate(String JRate) {
        this.JRate = JRate;
    }

    public String getCRate() {
        return CRate;
    }

    public void setCRate(String CRate) {
        this.CRate = CRate;
    }

    public String getZRate() {
        return ZRate;
    }

    public void setZRate(String ZRate) {
        this.ZRate = ZRate;
    }

    public String getSRate() {
        return SRate;
    }

    public void setSRate(String SRate) {
        this.SRate = SRate;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
