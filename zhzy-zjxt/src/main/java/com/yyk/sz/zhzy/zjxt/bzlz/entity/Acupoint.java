package com.yyk.sz.zhzy.zjxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 穴位
 * @Author: ZhangChao
 * @Date: 2018/11/23 15:34
 * @Version: 1.0
 */
public class Acupoint extends BaseEntity {

    private String acupointCode;
    private String acupointName;
    private String pinYinCode;
    private String meridianCode;
    private String meridianOrder;
    private String PType;
    private String pointX;
    private String pointY;
    private String positionExplain;
    private String drugFlag;

    public String getAcupointCode() {
        return acupointCode;
    }

    public void setAcupointCode(String acupointCode) {
        this.acupointCode = acupointCode;
    }

    public String getAcupointName() {
        return acupointName;
    }

    public void setAcupointName(String acupointName) {
        this.acupointName = acupointName;
    }

    public String getPinYinCode() {
        return pinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        this.pinYinCode = pinYinCode;
    }

    public String getPointX() {
        return pointX;
    }

    public void setPointX(String pointX) {
        this.pointX = pointX;
    }

    public String getPointY() {
        return pointY;
    }

    public void setPointY(String pointY) {
        this.pointY = pointY;
    }

    public String getPositionExplain() {
        return positionExplain;
    }

    public void setPositionExplain(String positionExplain) {
        this.positionExplain = positionExplain;
    }

    public String getDrugFlag() {
        return drugFlag;
    }

    public void setDrugFlag(String drugFlag) {
        this.drugFlag = drugFlag;
    }

    public String getMeridianCode() {
        return meridianCode;
    }

    public void setMeridianCode(String meridianCode) {
        this.meridianCode = meridianCode;
    }

    public String getMeridianOrder() {
        return meridianOrder;
    }

    public void setMeridianOrder(String meridianOrder) {
        this.meridianOrder = meridianOrder;
    }

    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }
}
