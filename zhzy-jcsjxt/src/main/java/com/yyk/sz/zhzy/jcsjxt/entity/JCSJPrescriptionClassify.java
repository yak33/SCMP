package com.yyk.sz.zhzy.jcsjxt.entity;


public class JCSJPrescriptionClassify {

    private String pccode;

    private String uuid;

    private String pcname;
    private String pcname2;

    private String pinyincode;

    public String getPcname2() {
        return pcname2;
    }

    public void setPcname2(String pcname2) {
        this.pcname2 = pcname2;
    }

    public String getPccode() {
        return pccode;
    }

    public void setPccode(String pccode) {
        this.pccode = pccode == null ? null : pccode.trim();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname == null ? null : pcname.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }
}