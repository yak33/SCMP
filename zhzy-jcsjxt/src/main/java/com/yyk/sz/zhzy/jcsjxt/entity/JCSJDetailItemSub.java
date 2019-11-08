package com.yyk.sz.zhzy.jcsjxt.entity;

import java.math.BigDecimal;
import java.util.Date;

public class JCSJDetailItemSub {

    private String uuid;

    private BigDecimal number;
    private String detailitemcode;
    private String medicalcarecode;
    private String medicalcarename;


    public JCSJDetailItemSub() {
        super();
    }

    public String getUuid() {
        return uuid;
    }


    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getDetailitemcode() {
        return detailitemcode;
    }

    public void setDetailitemcode(String detailitemcode) {
        this.detailitemcode = detailitemcode;
    }

    public String getMedicalcarecode() {
        return medicalcarecode;
    }

    public void setMedicalcarecode(String medicalcarecode) {
        this.medicalcarecode = medicalcarecode;
    }

    public String getMedicalcarename() {
        return medicalcarename;
    }

    public void setMedicalcarename(String medicalcarename) {
        this.medicalcarename = medicalcarename;
    }
}