package com.yyk.sz.zhzy.lzxt.jyjc.entity;

import java.math.BigDecimal;

public class SysInventoryTX {
    private Integer drugcode;

    private String drugname;

    private String othername;

    private String inputcode;

    private Integer units;

    private String packageunits;

    private String prescriptionunitname;

    /**
     * 预警值
     */
    private BigDecimal warningamount;

    /**
     * 剩余库存
     */
    private BigDecimal remainamount;

    public String getPrescriptionunitname() {
        return prescriptionunitname;
    }

    public void setPrescriptionunitname(String prescriptionunitname) {
        this.prescriptionunitname = prescriptionunitname;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public BigDecimal getRemainamount() {
        return remainamount;
    }

    public BigDecimal getWarningamount() {
        return warningamount;
    }

    public void setWarningamount(BigDecimal warningamount) {
        this.warningamount = warningamount;
    }

    public Integer getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(Integer drugcode) {
        this.drugcode = drugcode;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }


    public String getInputcode() {
        return inputcode;
    }

    public void setInputcode(String inputcode) {
        this.inputcode = inputcode == null ? null : inputcode.trim();
    }


    public String getPackageunits() {
        return packageunits;
    }

    public void setPackageunits(String packageunits) {
        this.packageunits = packageunits == null ? null : packageunits.trim();
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername == null ? null : othername.trim();
    }

    public void setRemainamount(BigDecimal remainamount) {
        this.remainamount = remainamount;
    }


}