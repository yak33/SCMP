package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJTongue {

    private String tonguecode;

    private String uuid;

    private String tonguename;
    private String tonguename2;

    private String pinyincode;
    private String tongueimage;

    public String getTonguename2() {
        return tonguename2;
    }

    public void setTonguename2(String tonguename2) {
        this.tonguename2 = tonguename2;
    }

    public String getTonguecode() {
        return tonguecode;
    }

    public void setTonguecode(String tonguecode) {
        this.tonguecode = tonguecode;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }


    public String getTonguename() {
        return tonguename;
    }

    public void setTonguename(String tonguename) {
        this.tonguename = tonguename == null ? null : tonguename.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }


    public String getTongueimage() {
        return tongueimage;
    }

    public void setTongueimage(String tongueimage) {
        this.tongueimage = tongueimage == null ? null : tongueimage.trim();
    }
}