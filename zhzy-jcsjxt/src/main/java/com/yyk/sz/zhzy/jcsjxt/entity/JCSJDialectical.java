package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJDialectical {

    private String dialecticalcode;

    private String uuid;

    private String dialecticalname;
    private String dialecticalname2;

    private String pinyincode;

    private String remark;

    public String getDialecticalname2() {
        return dialecticalname2;
    }

    public void setDialecticalname2(String dialecticalname2) {
        this.dialecticalname2 = dialecticalname2;
    }

    public String getDialecticalcode() {
        return dialecticalcode;
    }

    public void setDialecticalcode(String dialecticalcode) {
        this.dialecticalcode = dialecticalcode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDialecticalname() {
        return dialecticalname;
    }

    public void setDialecticalname(String dialecticalname) {
        this.dialecticalname = dialecticalname == null ? null : dialecticalname.trim();
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