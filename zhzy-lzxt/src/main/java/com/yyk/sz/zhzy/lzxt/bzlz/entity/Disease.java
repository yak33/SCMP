package com.yyk.sz.zhzy.lzxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class Disease extends BaseEntity {

    /**
     * 兼症编码
     */
    private String DiseaseCode;

    /**
     * 兼症名称
     */
    private String DiseaseName;

    /**
     *
     */
    private String selDisease;

    public String getDiseaseCode() {
        return DiseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        DiseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return DiseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        DiseaseName = diseaseName;
    }

    public String getSelDisease() {
        return selDisease;
    }

    public void setSelDisease(String selDisease) {
        this.selDisease = selDisease;
    }
}
