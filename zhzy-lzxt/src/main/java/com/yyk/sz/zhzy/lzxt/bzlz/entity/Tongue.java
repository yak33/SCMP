package com.yyk.sz.zhzy.lzxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class Tongue extends BaseEntity {

    /**
     * 舌像编码
     */
    private String TongueCode;

    /**
     * 舌像名称
     */
    private String TongueName;

    /**
     *
     */
    private String selTongue;

    /**
     * 舌像图片
     */
    private String TongueImage;

    public String getTongueImage() {
        return TongueImage;
    }

    public void setTongueImage(String tongueImage) {
        TongueImage = tongueImage;
    }

    public String getTongueCode() {
        return TongueCode;
    }

    public void setTongueCode(String tongueCode) {
        TongueCode = tongueCode;
    }

    public String getTongueName() {
        return TongueName;
    }

    public void setTongueName(String tongueName) {
        TongueName = tongueName;
    }

    public String getSelTongue() {
        return selTongue;
    }

    public void setSelTongue(String selTongue) {
        this.selTongue = selTongue;
    }
}
