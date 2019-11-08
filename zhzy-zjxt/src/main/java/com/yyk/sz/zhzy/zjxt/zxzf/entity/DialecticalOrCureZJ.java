package com.yyk.sz.zhzy.zjxt.zxzf.entity;

import com.terran4j.commons.api2doc.annotations.ApiComment;
import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * @Author: ZhangChao
 * @Date: 2018/11/30 14:48
 * @Version: 1.0
 */
public class DialecticalOrCureZJ extends BaseEntity {
    /**
     * 穴位code--drugCode
     */
    private String acupointCode;
    /**
     * 穴位名称
     */
    private String acupointName;
    /**
     * 拼音码
     */
    private String pinYinCode;
    /**
     * X坐标
     */
    @ApiComment("X坐标")
    private String pointX;
    /**
     * Y坐标
     */
    @ApiComment("Y坐标")
    private String pointY;
    /**
     * 所属经络
     */
    @ApiComment("所属经络")
    private String meridianName;
    /**
     * 在经络上的位置
     */
    @ApiComment("在经络上的顺序")
    private String meridianOrder;
    /**
     * 穴位说明
     */
    @ApiComment("穴位说明")
    private String positionExplain;
    private String meridianCode;
    /**
     * 穴位显示哪个图片上。1正面图 2侧面图3背面图
     */
    @ApiComment("穴位显示哪个图片上。1正面图 2侧面图3背面图")
    private String PType;


    public String getPType() {
        return PType;
    }

    public void setPType(String PType) {
        this.PType = PType;
    }

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

    public String getMeridianName() {
        return meridianName;
    }

    public void setMeridianName(String meridianName) {
        this.meridianName = meridianName;
    }

    public String getMeridianOrder() {
        return meridianOrder;
    }

    public void setMeridianOrder(String meridianOrder) {
        this.meridianOrder = meridianOrder;
    }

    public String getPositionExplain() {
        return positionExplain;
    }

    public void setPositionExplain(String positionExplain) {
        this.positionExplain = positionExplain;
    }

    public String getMeridianCode() {
        return meridianCode;
    }

    public void setMeridianCode(String meridianCode) {
        this.meridianCode = meridianCode;
    }
}
