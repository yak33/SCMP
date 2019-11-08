package com.yyk.sz.zhzy.jcsjxt.entity;

public class JCSJMainSymptom {

    private String mainsymptomcode;//主症编码

    private String uuid;

    private String mainsymptomname;
    private String mainsymptomname2;


    private String pinyincode;
    private String pinyincode2;

    private String mainsymptomtypecode;
    private String mainsymptomtypecode2;

    private String chinesemedicinecode;
    private String chinesemedicinecode2;

    private String meridianCode;//归经编码
    private String pulseCode;//脉象编码
    private String tongueCode;//舌像编码
    private String diseaseCode;//兼症编码
    private String systemCode;//系统编码


    public String getMainsymptomcode() {
        return mainsymptomcode;
    }

    public void setMainsymptomcode(String mainsymptomcode) {
        this.mainsymptomcode = mainsymptomcode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getMainsymptomname() {
        return mainsymptomname;
    }

    public void setMainsymptomname(String mainsymptomname) {
        this.mainsymptomname = mainsymptomname == null ? null : mainsymptomname.trim();
    }

    public String getPinyincode() {
        return pinyincode;
    }

    public void setPinyincode(String pinyincode) {
        this.pinyincode = pinyincode == null ? null : pinyincode.trim();
    }
    public String getMainsymptomtypecode() {
        return mainsymptomtypecode;
    }

    public void setMainsymptomtypecode(String mainsymptomtypecode) {
        this.mainsymptomtypecode = mainsymptomtypecode;
    }

    public String getChinesemedicinecode() {
        return chinesemedicinecode;
    }

    public void setChinesemedicinecode(String chinesemedicinecode) {
        this.chinesemedicinecode = chinesemedicinecode == null ? null : chinesemedicinecode.trim();
    }

    public String getMeridianCode() {
        return meridianCode;
    }

    public void setMeridianCode(String meridianCode) {
        this.meridianCode = meridianCode;
    }

    public String getPulseCode() {
        return pulseCode;
    }

    public void setPulseCode(String pulseCode) {
        this.pulseCode = pulseCode;
    }

    public String getTongueCode() {
        return tongueCode;
    }

    public void setTongueCode(String tongueCode) {
        this.tongueCode = tongueCode;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getMainsymptomname2() {
        return mainsymptomname2;
    }

    public void setMainsymptomname2(String mainsymptomname2) {
        this.mainsymptomname2 = mainsymptomname2;
    }

    public String getPinyincode2() {
        return pinyincode2;
    }

    public void setPinyincode2(String pinyincode2) {
        this.pinyincode2 = pinyincode2;
    }

    public String getMainsymptomtypecode2() {
        return mainsymptomtypecode2;
    }

    public void setMainsymptomtypecode2(String mainsymptomtypecode2) {
        this.mainsymptomtypecode2 = mainsymptomtypecode2;
    }

    public String getChinesemedicinecode2() {
        return chinesemedicinecode2;
    }

    public void setChinesemedicinecode2(String chinesemedicinecode2) {
        this.chinesemedicinecode2 = chinesemedicinecode2;
    }
}