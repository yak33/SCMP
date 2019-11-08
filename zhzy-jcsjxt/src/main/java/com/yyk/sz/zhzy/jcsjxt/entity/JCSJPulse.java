package com.yyk.sz.zhzy.jcsjxt.entity;


public class JCSJPulse {

    private String pulsecode;

    private String uuid;

    private String pulsename;
    private String pulsename2;

    private String pinyincode;

    private String remark;

    public String getPulsename2() {
        return pulsename2;
    }

    public void setPulsename2(String pulsename2) {
        this.pulsename2 = pulsename2;
    }

    public String getPulsecode() {
        return pulsecode;
    }

    public void setPulsecode(String pulsecode) {
        this.pulsecode = pulsecode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPulsename() {
        return pulsename;
    }

    public void setPulsename(String pulsename) {
        this.pulsename = pulsename == null ? null : pulsename.trim();
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