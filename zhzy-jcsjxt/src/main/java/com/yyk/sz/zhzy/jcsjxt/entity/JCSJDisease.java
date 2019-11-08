package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJDisease {

    private String diseasecode;


    private String uuid;

    private String diseasename;
    private String diseasename2;

    private String pinyincode;

    private String diseasemeridian;//兼症与归经的关系
    private String diseasemainsymptom;//兼症与主症的关系

    public String getDiseasename2() {
        return diseasename2;
    }

    public void setDiseasename2(String diseasename2) {
        this.diseasename2 = diseasename2;
    }

    public String getDiseasecode() {
        return diseasecode;
    }

    public void setDiseasecode(String diseasecode) {
        this.diseasecode = diseasecode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename == null ? null : diseasename.trim();
    }


    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }

    public String getDiseasemeridian() {
        return diseasemeridian;
    }

    public void setDiseasemeridian(String diseasemeridian) {
        this.diseasemeridian = diseasemeridian;
    }

    public String getDiseasemainsymptom() {
        return diseasemainsymptom;
    }

    public void setDiseasemainsymptom(String diseasemainsymptom) {
        this.diseasemainsymptom = diseasemainsymptom;
    }
}