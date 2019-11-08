package com.yyk.sz.zhzy.common.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class MecidalType extends BaseEntity {

    /**
     * 类型编码
     */
    private String MecidalTypeCode;

    /**
     * 类型名称
     */
    private String MecidalTypeName;

    private String ratio;

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    public String getMecidalTypeCode() {
        return MecidalTypeCode;
    }

    public void setMecidalTypeCode(String mecidalTypeCode) {
        MecidalTypeCode = mecidalTypeCode;
    }

    public String getMecidalTypeName() {
        return MecidalTypeName;
    }

    public void setMecidalTypeName(String mecidalTypeName) {
        MecidalTypeName = mecidalTypeName;
    }
}
