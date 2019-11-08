package com.yyk.sz.zhzy.lzxt.zjkf.entity;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 直接开方
 */
public class DirectPrescription extends BaseEntity {
    /**
     * 药品编码
     */
    @ApiComment(value = "药品编码", sample = "")
    public int drugCode;
    /**
     * 名称
     */
    @ApiComment(value = "名称", sample = "")
    public String drugName;
    /**
     * 输入码
     */
    @ApiComment(value = "输入码", sample = "")
    public String inputCode;
    /**
     * 商品名称
     */
    @ApiComment(value = "商品名称", sample = "")
    public String otherName;
    /**
     * HIS对应编码
     */
    @ApiComment(value = "HIS对应编码", sample = "")
    public String HISCorreCode;
    /**
     * 性味
     */
    @ApiComment(value = "性味", sample = "")
    public String drugTaste;
    /**
     * 归经
     */
    @ApiComment(value = "归经", sample = "")
    public String drugMeridian;
    /**
     * 中医病名编码
     */
    @ApiComment(value = "中医病名编码", sample = "")
    public String chineseMedicineCode;
    /**
     * 中医病名名称
     */
    @ApiComment(value = "中医病名名称", sample = "")
    public String chineseMedicineName;
    /**
     * 西医病名编码
     */
    @ApiComment(value = "西医病名编码", sample = "")
    public String westernMedicineCode;
    /**
     * 西医病名
     */
    @ApiComment(value = "西医病名", sample = "")
    public String westernMedicineName;
    /**
     * 拼音码
     */
    @ApiComment(value = "拼音码", sample = "")
    public String pinYinCode;
    /**
     * 归经编码
     */
    private String MeridianCode;
    /**
     * 归经名称
     */
    private String MeridianName;
    /**
     * 性味编码
     */
    private String TasteCode;
    /**
     * 性味名称
     */
    private String TasteName;

    public String getMeridianCode() {
        return MeridianCode;
    }

    public void setMeridianCode(String meridianCode) {
        MeridianCode = meridianCode;
    }

    public String getMeridianName() {
        return MeridianName;
    }

    public void setMeridianName(String meridianName) {
        MeridianName = meridianName;
    }

    public String getTasteCode() {
        return TasteCode;
    }

    public void setTasteCode(String tasteCode) {
        TasteCode = tasteCode;
    }

    public String getTasteName() {
        return TasteName;
    }

    public void setTasteName(String tasteName) {
        TasteName = tasteName;
    }

    public String getDrugTaste() {
        return drugTaste;
    }

    public void setDrugTaste(String drugTaste) {
        this.drugTaste = drugTaste;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getDrugMeridian() {
        return drugMeridian;
    }

    public void setDrugMeridian(String drugMeridian) {
        this.drugMeridian = drugMeridian;
    }

    public int getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(int drugCode) {
        this.drugCode = drugCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getHISCorreCode() {
        return HISCorreCode;
    }

    public void setHISCorreCode(String HISCorreCode) {
        this.HISCorreCode = HISCorreCode;
    }

    public String getChineseMedicineCode() {
        return chineseMedicineCode;
    }

    public void setChineseMedicineCode(String chineseMedicineCode) {
        this.chineseMedicineCode = chineseMedicineCode;
    }

    public String getChineseMedicineName() {
        return chineseMedicineName;
    }

    public void setChineseMedicineName(String chineseMedicineName) {
        this.chineseMedicineName = chineseMedicineName;
    }

    public String getWesternMedicineCode() {
        return westernMedicineCode;
    }

    public void setWesternMedicineCode(String westernMedicineCode) {
        this.westernMedicineCode = westernMedicineCode;
    }

    public String getWesternMedicineName() {
        return westernMedicineName;
    }

    public void setWesternMedicineName(String westernMedicineName) {
        this.westernMedicineName = westernMedicineName;
    }
}
