package com.yyk.sz.zhzy.gcxt.bzlz.entity;

import com.yyk.sz.common.base.domain.BaseEntity;


public class GCMainSymptom extends BaseEntity {

    /**
     * 主症编码
     */
    private String MainSymptomCode;

    /**
     * 主症名称
     */
    private String MainSymptomName;

    /**
     * 拼音码
     */
    private String PinYinCode;

    /**
     * 主症分类名称
     */
    private String MainSymptomTypeName;

    /**
     * 分值
     */
    private String Soue;

    /**
     * 科室编码
     */
    private String DeptCode;

    public String getMainSymptomCode() {
        return MainSymptomCode;
    }

    public void setMainSymptomCode(String mainSymptomCode) {
        MainSymptomCode = mainSymptomCode;
    }

    public String getMainSymptomName() {
        return MainSymptomName;
    }

    public void setMainSymptomName(String mainSymptomName) {
        MainSymptomName = mainSymptomName;
    }

    public String getPinYinCode() {
        return PinYinCode;
    }

    public void setPinYinCode(String pinYinCode) {
        PinYinCode = pinYinCode;
    }

    public String getMainSymptomTypeName() {
        return MainSymptomTypeName;
    }

    public void setMainSymptomTypeName(String mainSymptomTypeName) {
        MainSymptomTypeName = mainSymptomTypeName;
    }

    public String getSoue() {
        return Soue;
    }

    public void setSoue(String soue) {
        Soue = soue;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }
}
