package com.yyk.sz.zhzy.lzxt.zjkf.entity;

public class DrugTaboos {

    private String uuid;

    private Integer drugtaboostype;

    private Integer drugcode;

    private Integer drugcodeone;

    private Integer quanitity;

    private Integer drugflag;

    private String drugname;

    private String drugonename;

    public DrugTaboos() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getDrugtaboostype() {
        return drugtaboostype;
    }

    public void setDrugtaboostype(Integer drugtaboostype) {
        this.drugtaboostype = drugtaboostype;
    }

    public Integer getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(Integer drugcode) {
        this.drugcode = drugcode;
    }

    public Integer getDrugcodeone() {
        return drugcodeone;
    }

    public void setDrugcodeone(Integer drugcodeone) {
        this.drugcodeone = drugcodeone;
    }

    public Integer getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(Integer quanitity) {
        this.quanitity = quanitity;
    }

    public Integer getDrugflag() {
        return drugflag;
    }

    public void setDrugflag(Integer drugflag) {
        this.drugflag = drugflag;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDrugonename() {
        return drugonename;
    }

    public void setDrugonename(String drugonename) {
        this.drugonename = drugonename;
    }
}