package com.yyk.sz.zhzy.jcsjxt.entity;


public class JCSJDrugTaboos {

    private String uuid;

    private String drugtaboostype;

    private String drugtaboostypename;
    private String drugname;
    private String drugnameone;
    private String drugflagname;

    private String drugcode;

    private String drugcodeone;

    private String quanitity;

    private String drugflag;

    public String getDrugtaboostypename() {
        return drugtaboostypename;
    }

    public void setDrugtaboostypename(String drugtaboostypename) {
        this.drugtaboostypename = drugtaboostypename;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDrugnameone() {
        return drugnameone;
    }

    public void setDrugnameone(String drugnameone) {
        this.drugnameone = drugnameone;
    }

    public String getDrugflagname() {
        return drugflagname;
    }

    public void setDrugflagname(String drugflagname) {
        this.drugflagname = drugflagname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDrugtaboostype() {
        return drugtaboostype;
    }

    public void setDrugtaboostype(String drugtaboostype) {
        this.drugtaboostype = drugtaboostype;
    }

    public String getDrugcode() {
        return drugcode;
    }

    public void setDrugcode(String drugcode) {
        this.drugcode = drugcode;
    }

    public String getDrugcodeone() {
        return drugcodeone;
    }

    public void setDrugcodeone(String drugcodeone) {
        this.drugcodeone = drugcodeone;
    }

    public String getQuanitity() {
        return quanitity;
    }

    public void setQuanitity(String quanitity) {
        this.quanitity = quanitity;
    }

    public String getDrugflag() {
        return drugflag;
    }

    public void setDrugflag(String drugflag) {
        this.drugflag = drugflag;
    }
}