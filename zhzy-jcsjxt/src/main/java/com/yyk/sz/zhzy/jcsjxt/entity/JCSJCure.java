package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJCure {

    private String curecode;

    private String uuid;


    private String curename;
    private String curename2;


    private String pinyincode;

    private String remark;

    public String getCurename2() {
        return curename2;
    }

    public void setCurename2(String curename2) {
        this.curename2 = curename2;
    }

    public String getCurecode() {
        return curecode;
    }

    public void setCurecode(String curecode) {
        this.curecode = curecode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getCurename() {
        return curename;
    }

    public void setCurename(String curename) {
        this.curename = curename == null ? null : curename.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}