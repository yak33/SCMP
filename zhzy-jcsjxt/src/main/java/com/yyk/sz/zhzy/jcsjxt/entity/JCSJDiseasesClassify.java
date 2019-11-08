package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJDiseasesClassify {

    private String dccode;

    private String uuid;

    private String dcname;
    private String dcname2;

    private String pinyincode;

    private String chinesemedicinecode;

    public String getDcname2() {
        return dcname2;
    }

    public void setDcname2(String dcname2) {
        this.dcname2 = dcname2;
    }

    public String getChinesemedicinecode() {
        return chinesemedicinecode;
    }

    public void setChinesemedicinecode(String chinesemedicinecode) {
        this.chinesemedicinecode = chinesemedicinecode;
    }

    public String getDccode() {
        return dccode;
    }

    public void setDccode(String dccode) {
        this.dccode = dccode == null ? null : dccode.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDcname() {
        return dcname;
    }

    public void setDcname(String dcname) {
        this.dcname = dcname == null ? null : dcname.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }
}