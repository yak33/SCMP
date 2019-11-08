package com.yyk.sz.zhzy.jcsjxt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class JCSJPrescriptionSub {
    private String uuid;
    private String prescriptioncode;
    private String drugcode;
    private String prescriptionsubid;
    private String quanitity;
    private String suffertypecode;

    private String jflag;


    private String cflag;

    private String zflag;

    private String sflag;

    private String remark;

    private String mainflag;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPrescriptioncode() {
        return prescriptioncode;
    }

    public void setPrescriptioncode(String prescriptioncode) {
        this.prescriptioncode = prescriptioncode;
    }

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public String getPrescriptionsubid() {
        return prescriptionsubid;
    }

    public void setPrescriptionsubid(String prescriptionsubid) {
        this.prescriptionsubid = prescriptionsubid;
    }

    public String getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(String quanitity) {
        this.quanitity = quanitity;
    }

    public String getSuffertypecode() {
        return suffertypecode;
    }

    public void setSuffertypecode(String suffertypecode) {
        this.suffertypecode = suffertypecode;
    }

    public String getJflag() {
        return jflag;
    }

    public void setJflag(String jflag) {
        this.jflag = jflag;
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag;
    }

    public String getZflag() {
        return zflag;
    }

    public void setZflag(String zflag) {
        this.zflag = zflag;
    }

    public String getSflag() {
        return sflag;
    }

    public void setSflag(String sflag) {
        this.sflag = sflag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMainflag() {
        return mainflag;
    }

    public void setMainflag(String mainflag) {
        this.mainflag = mainflag;
    }
}