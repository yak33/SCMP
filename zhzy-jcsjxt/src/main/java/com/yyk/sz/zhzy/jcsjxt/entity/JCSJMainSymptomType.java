package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJMainSymptomType {

    private String mainsymptomtypecode;

    private String uuid;

    private String mainsymptomtypename;

    private String mainsymptomtypename2;


    private String remark;

    public String getMainsymptomtypename2() {
        return mainsymptomtypename2;
    }

    public void setMainsymptomtypename2(String mainsymptomtypename2) {
        this.mainsymptomtypename2 = mainsymptomtypename2;
    }

    public String getMainsymptomtypecode() {
        return mainsymptomtypecode;
    }


    public void setMainsymptomtypecode(String mainsymptomtypecode) {
        this.mainsymptomtypecode = mainsymptomtypecode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getMainsymptomtypename() {
        return mainsymptomtypename;
    }

    public void setMainsymptomtypename(String mainsymptomtypename) {
        this.mainsymptomtypename = mainsymptomtypename == null ? null : mainsymptomtypename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

 }