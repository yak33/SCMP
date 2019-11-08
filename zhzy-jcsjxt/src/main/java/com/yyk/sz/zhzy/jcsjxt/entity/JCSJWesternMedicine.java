package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJWesternMedicine {

    private String westernmedicinecode;

    private String uuid;

    private String westernmedicinename;
    private String westernmedicinename2;

    private String pinyincode;

    public String getWesternmedicinename2() {
        return westernmedicinename2;
    }

    public void setWesternmedicinename2(String westernmedicinename2) {
        this.westernmedicinename2 = westernmedicinename2;
    }

    public String getWesternmedicinecode() {
        return westernmedicinecode;
    }

    public void setWesternmedicinecode(String westernmedicinecode) {
        this.westernmedicinecode = westernmedicinecode == null ? null : westernmedicinecode.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getWesternmedicinename() {
        return westernmedicinename;
    }

    public void setWesternmedicinename(String westernmedicinename) {
        this.westernmedicinename = westernmedicinename == null ? null : westernmedicinename.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }
}