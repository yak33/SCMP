package com.yyk.sz.zhzy.lzxt.zjkf.entity;

import com.yyk.sz.common.base.domain.BaseEntity;

/**
 * 性味
 */
public class Taste extends BaseEntity {
    /**
     * 草药编码
     */
    private String DrugCode;
    /**
     * 性味编码
     */
    private String TasteCode;
    /**
     * 性味名称
     */
    private String TasteName;

    public String getDrugCode() {
        return DrugCode;
    }

    public void setDrugCode(String drugCode) {
        DrugCode = drugCode;
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
}
