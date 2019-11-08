package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJChineseMedicine {

    private String chinesemedicinecode;

    private String uuid;

    private String chinesemedicinename;
    private String chinesemedicinename2;

    private String pinyincode;

    private String chinesemedicinedm;

    public String getChinesemedicinename2() {
        return chinesemedicinename2;
    }

    public void setChinesemedicinename2(String chinesemedicinename2) {
        this.chinesemedicinename2 = chinesemedicinename2;
    }

    public String getChinesemedicinecode() {
        return chinesemedicinecode;
    }

    public void setChinesemedicinecode(String chinesemedicinecode) {
        this.chinesemedicinecode = chinesemedicinecode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getChinesemedicinename() {
        return chinesemedicinename;
    }

    public void setChinesemedicinename(String chinesemedicinename) {
        this.chinesemedicinename = chinesemedicinename == null ? null : chinesemedicinename.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }

    public String getChinesemedicinedm() {
        return chinesemedicinedm;
    }

    public void setChinesemedicinedm(String chinesemedicinedm) {
        this.chinesemedicinedm = chinesemedicinedm == null ? null : chinesemedicinedm.trim();
    }
}